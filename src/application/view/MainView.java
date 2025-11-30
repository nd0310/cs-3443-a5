package application.view;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainView {

    private Label timeLabel;
    private Label scoreLabel;
    private ImageView[] imageViews;

    public MainView(Label timeLabel, Label scoreLabel, ImageView[] imageViews) {
        this.timeLabel = timeLabel;
        this.scoreLabel = scoreLabel;
        this.imageViews = imageViews;
    }

    public void displayTimeRemaining(String timeText) {
        Platform.runLater(() -> timeLabel.setText(timeText));
    }

    public void displayLabel(String labelType, String text) {
    	Platform.runLater(() -> { 
    		if ("time".equalsIgnoreCase(labelType)) {
    			timeLabel.setText(text); 
    		} else if ("score".equalsIgnoreCase(labelType)) { 
    			scoreLabel.setText(text); 
    		} 
    	}); 
    }

    public void displayImage(int index, Image image) {
        if (index < 0 || index >= imageViews.length) return;

        Platform.runLater(() -> imageViews[index].setImage(image));
    }
}
