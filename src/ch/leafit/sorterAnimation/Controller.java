package ch.leafit.sorterAnimation;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public final class Controller {
	
	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private Button buStart; // Value injected by FXMLLoader
	@FXML
	private TextArea txaDisplay; // Value injected by FXMLLoader
	@FXML
	private Canvas canvas;
    @FXML
    private ComboBox<String> comboSorter;
    @FXML
    private TextField txfSpeed;
    
    private int speed=500;

	@FXML
	void actStart(ActionEvent event) {
		buStart.setDisable(true);
		comboSorter.setDisable(true);
		txfSpeed.setDisable(true);
		try{speed=Integer.parseInt(txfSpeed.getText().trim());}
		catch(Exception e){speed=500;}
		String method = comboSorter.getValue();
		if(method.compareTo(Methods.Bubble.toString())==0) new BubbleSorter(this,speed);
		if(method.compareTo(Methods.Selection.toString())==0) new SelectionSorter(this,speed);
	}
	
	public void enableDisplay(){
		buStart.setDisable(false);
		comboSorter.setDisable(false);
		txfSpeed.setDisable(false);
	}

	public void drawShapes(int[] ia, int lastBlue, int current) {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		int deltaX = (int) ((canvas.getWidth() / ia.length));
		int x = 10;
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		gc.strokeLine(0, 0, canvas.getWidth(), 0);
		gc.setFill(Color.GREEN);
		gc.setLineWidth(5);
		for (int i = 0; i < ia.length; i++) {
			if (i <= lastBlue)
				gc.setStroke(Color.BLUE);
			else
				gc.setStroke(Color.BLACK);
			if (i == current)
				gc.setStroke(Color.RED);
			gc.strokeLine(x, 0, x, ia[i]);
			gc.fillText(""+ia[i], x+5, 20);
			x += deltaX;
		}
	}
	
	public void drawShapes(int[] ia, int lastBlue, int current, int minIndex) {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		int deltaX = (int) ((canvas.getWidth() / ia.length));
		int x = 10;
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		gc.strokeLine(0, 0, canvas.getWidth(), 0);
		gc.setFill(Color.GREEN);
		gc.setLineWidth(5);
		for (int i = 0; i < ia.length; i++) {
			if (i <= lastBlue)
				gc.setStroke(Color.BLUE);
			else
				gc.setStroke(Color.BLACK);
			if (i == current)
				gc.setStroke(Color.RED);
			if (i == minIndex)
				gc.setStroke(Color.YELLOW);
			gc.strokeLine(x, 0, x, ia[i]);
			gc.fillText(""+ia[i], x+5, 20);
			x += deltaX;
		}
	}
	
	private GraphicsContext gc;
	private enum Methods{Bubble,Selection}

	@FXML
	void initialize() {
		gc = canvas.getGraphicsContext2D();
		comboSorter.getItems().addAll(
				Methods.Bubble.toString(),
			    Methods.Selection.toString()
			);
		comboSorter.setValue(Methods.Bubble.toString());
	}
}
