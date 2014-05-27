package ch.leafit.parallelTransition;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
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

		FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), n);
		fadeTransition.setFromValue(1.0);
		fadeTransition.setToValue(0.3);
		fadeTransition.setCycleCount(2);
		fadeTransition.setAutoReverse(true);
		
		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), n);
		translateTransition.setFromX(50);
		translateTransition.setToX(350);
		translateTransition.setCycleCount(2);
		translateTransition.setAutoReverse(true);
		
		RotateTransition rotateTransition = new RotateTransition(Duration.millis(3000), n);
		rotateTransition.setByAngle(180f);
		rotateTransition.setCycleCount(4);
		rotateTransition.setAutoReverse(true);
		
		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), n);
		scaleTransition.setToX(2f);
		scaleTransition.setToY(2f);
		scaleTransition.setCycleCount(2);
		scaleTransition.setAutoReverse(true);

		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(fadeTransition,translateTransition, rotateTransition, scaleTransition);
		parallelTransition.setCycleCount(Timeline.INDEFINITE);
		parallelTransition.play();
    }

    @FXML
    void initialize() {
    	pathTr(rectangle);
    	pathTr(text);
    }
}
