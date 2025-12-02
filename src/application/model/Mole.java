package application.model;

import java.util.Random;

import application.view.MainView;
import javafx.scene.image.Image;


/**
 * Class implementing {@code Runnable} interface that
 * is responsible for hiding and showing the mole
 * @author Nathan Davies
 */
public class Mole implements Runnable {

  private WhackAMole game;
  private MainView mainView;
  private Image moleImage;
  private int index;
  private Random rand;
  
  private static final int MIN_HIDDEN_TIME = 2000;
  private static final int MAX_HIDDEN_TIME = 5000;
  private static final int MIN_SHOWN_TIME = 2000;
  private static final int MAX_SHOWN_TIME = 1000;
  
  public Mole(WhackAMole game, MainView mainView, int index, Image moleImage, Random rand) {
    this.game = game;
    this.mainView = mainView;
    this.moleImage = moleImage;
    this.index = index;
    this.rand = rand;
	}


  /**
   * Helper method to generate random numbers
   * @param min the minimum number
   * @param max the maximum number
   * @return a random number between min and max
   */
  private int randRange(int min, int max) {
    return this.rand.nextInt(max - min + 1) + min;
  }

  
  /**
   * Helper method to hide the mole
   */
  private void hide() {
    game.setExposed(index, false);
    mainView.displayImage(index, null);
  }

  /**
   * Helper method to show the mole
   */
  private void show() {
    game.setExposed(index, true);
    mainView.displayImage(index, moleImage);
  }


  /**
   * run method for the mole that controls the hiding and
   * showing of the mole
   */
  @Override
  public synchronized void run() {

    while(!game.gameOver()) {
      
      try {
        wait(randRange(MIN_HIDDEN_TIME, MAX_HIDDEN_TIME));
      } catch(InterruptedException e) {
        if(game.gameOver()) 
          break;
      }

      show();

      var startTime = System.currentTimeMillis();
      
      try {
        wait(randRange(MIN_SHOWN_TIME, MAX_SHOWN_TIME));
        throw new InterruptedException();
      } catch(InterruptedException e) {
        if(game.gameOver()) {
          break;
        } else {
          var reactionTime = System.currentTimeMillis() - startTime;
          game.updateScore((int)reactionTime);
        }
      } finally {
        hide();
      }
    }
  }
}
