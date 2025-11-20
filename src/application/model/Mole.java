package application.model;

import java.util.Random;

import application.view.MainView;
import javafx.scene.image.Image;

public class Mole {

  private WhackAMole game;
  private MainView mainView;
  private Image moleImage;
  private int index;
  private Random rand;

  public synchronized void run() {
    throw new RuntimeException("Not Implemented");
  }
}
