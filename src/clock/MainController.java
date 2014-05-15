package clock;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

  @FXML
  private ResourceBundle resources;

  @FXML
  private URL location;

  @FXML
  private Label lbHours;

  @FXML
  private Label lbMinutes;

  @FXML
  private Label lbSeconds;

  @FXML
  private Button btnStart;

  private IntegerProperty secProp = new SimpleIntegerProperty();
  private IntegerProperty minProp = new SimpleIntegerProperty();
  private IntegerProperty hrsProp = new SimpleIntegerProperty();
  
  @FXML
  void initialize() {
    //bind the display objects to IntegerProperty
    lbSeconds.textProperty().bind(secProp.asString());
    lbMinutes.textProperty().bind(minProp.asString());
    lbHours.textProperty().bind(hrsProp.asString());

    new Worker(secProp, minProp, hrsProp); //Worker is a JavaThread
  }
  
  @FXML
  void buttonClicked(ActionEvent event) {
    System.out.println("Button pressed");
  }

}
