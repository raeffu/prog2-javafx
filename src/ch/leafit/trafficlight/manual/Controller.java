package ch.leafit.trafficlight.manual;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public final class Controller {
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Circle cRed;

    @FXML
    private Circle cOrange;

    @FXML
    private Circle cGreen;
    
    private DisplayManager displayManager;
    
    @FXML
    private Button buOrange;
    @FXML
    private Button buRed;
    @FXML
    private Button buGreen;

    
    @FXML
    void actRed(ActionEvent event) {
    	displayManager.setToRed();
    }

    @FXML
    void actGreen(ActionEvent event) {
    	displayManager.setToGreen();
    }

    @FXML
    void actOrange(ActionEvent event) {
    	displayManager.setToOrange();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	displayManager = new DisplayManager(cRed,cOrange, cGreen );
    	displayManager.setToRed();
    }
}
