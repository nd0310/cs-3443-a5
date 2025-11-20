package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main class for the Calculator application.
 * It launches the JavaFX application and sets up the main scene.
 */
public class Main extends Application {
  /**
   * The main method, which launches the application.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * The main entry point for all JavaFX applications.
   * The start method is called after the init method has returned,
   * and after the system is ready for the application to begin running.
   *
   * @param stage the primary stage for this application, onto which
   * the application scene can be set.
   * @throws IOException if the fxml file cannot be loaded.
   */
  @Override
  public void start(Stage stage) throws IOException {
    var fxml = getClass().getResource("/res/WhackAMole.fxml");
    var loader = new FXMLLoader(fxml);
    var mainScene = new Scene(loader.load());

    stage.setScene(mainScene);
    stage.setTitle("WhackAMole");
    stage.show();

  }
}
