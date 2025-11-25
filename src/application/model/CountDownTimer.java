package application.model;

import application.view.MainView;

/**
 * @author Nathan Davies
 * Class implementing {@code Runnable} interface for keeping track of game time
 */
public class CountDownTimer implements Runnable {
  
  private WhackAMole game;
  private MainView mainView;
  private int durationSeconds;
  
  /**
   * @author Nathan Davies
   * Counts down {@code durationSeconds} updating the time remaining label
   * and calling {@code WhackAMole.endGame()} after the timer reaches zero
   * */
  @Override
  public synchronized void run()  {
    while (durationSeconds > 0) {
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        throw new RuntimeException("Unreachable");
      }
      durationSeconds -= 1;
      mainView.displayRemainingTime();
    }
    game.endGame();
  }
} 
