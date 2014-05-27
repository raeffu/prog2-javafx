package ch.leafit.sequentialTransition;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public final class Controller {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Rectangle rectangle;
    @FXML
    private Text text;
    @FXML
    private AnchorPane aPane;
    
    private void pathTr(Node n){

		FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), n);
		fadeTransition.setFromValue(1.0f);
		fadeTransition.setToValue(0.3f);
		fadeTransition.setCycleCount(1);
		fadeTransition.setAutoReverse(true);

		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), n);
		translateTransition.setFromX(50);
		translateTransition.setToX(375);
		translateTransition.setCycleCount(1);
		translateTransition.setAutoReverse(true);

		RotateTransition rotateTransition = new RotateTransition(Duration.millis(2000), n);
		rotateTransition.setByAngle(180f);
		rotateTransition.setCycleCount(4);
		rotateTransition.setAutoReverse(true);

		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), n);
		scaleTransition.setFromX(1);
		scaleTransition.setFromY(1);
		scaleTransition.setToX(2);
		scaleTransition.setToY(2);
		scaleTransition.setCycleCount(1);
		scaleTransition.setAutoReverse(true);

		SequentialTransition sequentialTransition = new SequentialTransition();
		sequentialTransition.getChildren().addAll(fadeTransition,translateTransition, rotateTransition, scaleTransition);

		sequentialTransition.setCycleCount(Timeline.INDEFINITE);
		sequentialTransition.setAutoReverse(true);

		sequentialTransition.play();
    }

    @FXML
    void initialize() {
    	pathTr(rectangle);
    	pathTr(text);
    }
}
