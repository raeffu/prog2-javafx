package ch.leafit.clock_RunnableBased;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public final class Controller {
	
    private Chronometer task;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML // fx:id="laDisplay"
    private Label laDisplay; 

    @FXML // fx:id="buStop"
    private Button buStop; // Value injected by FXMLLoader

    @FXML // fx:id="buStart"
    private Button buStart; // Value injected by FXMLLoader

    @FXML // fx:id="buLap"
    private Button buLap; // Value injected by FXMLLoader
    
    @FXML
    void actStart(ActionEvent event) {
    	    task = new Chronometer(laDisplay);
            new Thread(task).start();
            buStart.setDisable(true);
            buStop.setDisable(false);
            buLap.setDisable(false);
    }
    
    @FXML
    void actLap(ActionEvent event) {
    	if(((Chronometer)task).isDisplayOn())((Chronometer)task).disableDisplay();
    	else ((Chronometer)task).enableDisplay();
        buStart.setDisable(true);
        buStop.setDisable(false);
        buLap.setDisable(false);
    }

    @FXML
    void actStop(ActionEvent event) {
        task.stopIt();
        buStart.setDisable(false);
        buStop.setDisable(true);
        buLap.setDisable(true);
    }

    @FXML
    void initialize() {
        buStart.setDisable(false);
        buStop.setDisable(true);
        buLap.setDisable(true);
    }
}
