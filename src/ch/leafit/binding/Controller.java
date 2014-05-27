package ch.leafit.binding;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public final class Controller {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location; 
    @FXML
    private TextField txfDisplay;
    @FXML
    private Text txtMessage;
    @FXML
    private TextField txfInput;
    @FXML
    private Label laDisplay;
   
    @FXML
    void actTextField(ActionEvent event) {
    	try{int i = Integer.parseInt(txfInput.getText().trim());
    		intProperty.set(i);
    		stringProperty.set("All OK");
    	}
    	catch(Exception m){stringProperty.set("NOT A NUMBER!");}
    }
    
    // Define Properties
    private IntegerProperty intProperty = new SimpleIntegerProperty();
    private StringProperty stringProperty = new SimpleStringProperty();

    @FXML
    void initialize() {
        // Bind the objects to Properties
    	laDisplay.textProperty().bind(intProperty.asString());
    	txfDisplay.textProperty().bind(intProperty.asString());
    	txtMessage.textProperty().bind(stringProperty);
    }
}
