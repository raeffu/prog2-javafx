package sorting;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class MainController {

  @FXML
  private ResourceBundle resources;

  @FXML
  private URL location;

  @FXML
  private Button btnStart;

  @FXML
  private ComboBox<String> cbSort;

  @FXML
  private TextField txtSpeed;

  @FXML
  private Canvas canvas;

  private int speed = 500;
  private GraphicsContext gc;

  private enum SortMethods {
    BUBBLE, SELECT
  };

  @FXML
  void actStart(ActionEvent event) {
    btnStart.setDisable(true);
    cbSort.setDisable(true);
    txtSpeed.setDisable(true);

    speed = Integer.parseInt(txtSpeed.getText().trim());

    String method = cbSort.getValue();

    if (SortMethods.BUBBLE.toString().equals(method)) {
      new BubbleSorter(this, speed);
    }
    else if (SortMethods.SELECT.toString().equals(method)) {
      new SelectionSorter(this, speed);
    }

  }
  
  public void enableElements(){
    btnStart.setDisable(false);
    cbSort.setDisable(false);
    txtSpeed.setDisable(false);
  }

  public void drawShapes(int[] ia, int blue, int current) {
    // clear canvas
    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

    int deltaX = (int) ((canvas.getWidth() / ia.length));
    int x = 10;
    
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(2);
    gc.strokeLine(0, 0, canvas.getWidth(), 0);
    gc.setFill(Color.GREEN);
    gc.setLineWidth(5);
    
    for (int i = 0; i < ia.length; i++) {
      if (i <= blue)
        gc.setStroke(Color.BLUE);
      else
        gc.setStroke(Color.BLACK);
      if (i == current)
        gc.setStroke(Color.RED);
      gc.strokeLine(x, 0, x, ia[i]);
      gc.fillText("" + ia[i], x + 5, 20);
      x += deltaX;
    }
  }
  
  public void drawShapes(int[] ia, int blue, int current, int minIndex) {
    // clear canvas
    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

    int deltaX = (int) ((canvas.getWidth() / ia.length));
    int x = 10;
    
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(2);
    gc.strokeLine(0, 0, canvas.getWidth(), 0);
    gc.setFill(Color.GREEN);
    gc.setLineWidth(5);
    
    for (int i = 0; i < ia.length; i++) {
      if (i <= blue)
        gc.setStroke(Color.BLUE);
      else
        gc.setStroke(Color.BLACK);
      if (i == current)
        gc.setStroke(Color.RED);
      gc.strokeLine(x, 0, x, ia[i]);
      gc.fillText("" + ia[i], x + 5, 20);
      x += deltaX;
    }
  }
  
  @FXML
  void initialize() {
    assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'Main.fxml'.";
    assert cbSort != null : "fx:id=\"cbSort\" was not injected: check your FXML file 'Main.fxml'.";
    assert txtSpeed != null : "fx:id=\"txtSpeed\" was not injected: check your FXML file 'Main.fxml'.";

    gc = canvas.getGraphicsContext2D();
    
    txtSpeed.setText("1000");

    cbSort.getItems().clear();
    cbSort.getItems().addAll(SortMethods.BUBBLE.toString(),
        SortMethods.SELECT.toString());
    cbSort.setValue(SortMethods.BUBBLE.toString());
  }

}