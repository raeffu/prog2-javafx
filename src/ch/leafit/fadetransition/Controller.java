package ch.leafit.fadetransition;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
    
    private void faceNode(Node n){
		FadeTransition ft = new FadeTransition(Duration.millis(2000), n);
		ft.setFromValue(1.0);   // 100%
		ft.setToValue(0.0);     // 0%
		ft.setCycleCount(Timeline.INDEFINITE); // endlessly
		ft.setAutoReverse(true); // come back from 0% to 100% etc.
		ft.play();
    }

    @FXML
    void initialize() {
    	faceNode(rectangle);
    	faceNode(text);
    }
}
