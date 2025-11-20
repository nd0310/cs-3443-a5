package application.model;

import java.util.Random;

import application.view.MainView;

public class WhackAMole {

  private MainView mainView;
  private CountDownTimer timer;
  private Mole[] moles;
  private Thread[] moleThreads;
  private boolean[] exposed;
  private Random rand;
  private int totalScore;
  private boolean gameIsOver;

  public void setExposed(int index, boolean expsed) {
    this.exposed[index] = expsed;
  }

  public void startGame() {
    this.gameIsOver = false;
  }

  public void endGame() {
    this.gameIsOver = true;

  }

  public synchronized void updateScore(int responseTimeMillis) {

  }

  public boolean gameOver() {
    return gameIsOver;
  }


}
