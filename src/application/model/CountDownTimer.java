package application.model;

import application.view.MainView;

public class CountDownTimer {

  private WhackAMole game;
  private MainView mainView;
  private int durationSeconds;

  public synchronized void run() {
    throw new RuntimeException("Not Implemented");
  }

}
