package ch.leafit.binding.JavaWorkerThread;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Label laHourDisplay;
    @FXML
    private Label laMinDisplay;
    @FXML
    private Label laSecDisplay;
    
    private IntegerProperty secProp = new SimpleIntegerProperty();
    private IntegerProperty minProp = new SimpleIntegerProperty();
    private IntegerProperty hourProp = new SimpleIntegerProperty();

    @FXML
    void initialize() {
        // Bind the display objects to IntegerProperty 
    	laSecDisplay.textProperty().bind(secProp.asString());
    	laMinDisplay.textProperty().bind(minProp.asString());
    	laHourDisplay.textProperty().bind(hourProp.asString());
    	new Worker(secProp, minProp, hourProp); // Worker is a Java Thread
    }
}
