package ch.leafit.startstop.sample1;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public final class Controller {
	
	private A a;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="buStop"
    private Button buStop; // Value injected by FXMLLoader

    @FXML // fx:id="buStart"
    private Button buStart; // Value injected by FXMLLoader

    @FXML
    void actStart(ActionEvent event) {
    	a = new A("Thread: "+ ++i);
    	buStart.setDisable(true);
    	buStop.setDisable(false);
    }
    
    private int i=0;

	@FXML
    void actStop(ActionEvent event) {
    	a.interrupt();
    	buStart.setDisable(false);
    	buStop.setDisable(true);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	buStart.setDisable(false);
    	buStop.setDisable(true);
    }
}
