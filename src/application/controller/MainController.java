package application.controller;

import application.model.WhackAMole;
import application.view.MainView;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MainController {
  
  @FXML Label timeRemainingLabel;
  @FXML Label scoreLabel;
  
  @FXML ImageView img0;
  @FXML ImageView img1;
  @FXML ImageView img2;
  @FXML ImageView img3;
  @FXML ImageView img4;

  @FXML Pane pane0;
  @FXML Pane pane1;
  @FXML Pane pane2;
  @FXML Pane pane3;
  @FXML Pane pane4;

  private WhackAMole game;
  private MainView view;
  
  public void initialize() {
    Pane[] panes = { pane0, pane1, pane2, pane3, pane4};
      for ( Pane p : panes ){
      p.setStyle("-fx-border-color: black; -fx-border-width: 2;");
      }
    
    Image moleImage = new Image(getClass().getResource("/application/view/mole.png").toExternalForm());

      ImageView[] imgs = {img0, img1, img2, img3, img4};

        for (int i = 0; i < imgs.length; i++) {
            imgs[i].setUserData(i);   // Store the index so you know which mole was clicked
        }
    this.view = new MainView(timeRemainingLabel, scoreLabel, imgs);
    this.game = new WhackAMole(view, moleImage);
  }
  
  @FXML
  public void imageViewAction(Event e) {
    game.whackMole((int) ( (ImageView) e.getSource()).getUserData());
  }
  
  @FXML
  public void startButtonAction() {
    game.startGame();
  }
  
}
