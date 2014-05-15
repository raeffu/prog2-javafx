package ch.leafit.trafficlight.manual;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class DisplayManager {
	
	private Circle cRed,  cOrange,  cGreen;
	
	DisplayManager(Circle cRed, Circle cOrange, Circle cGreen){
		this.cRed=cRed;
		this.cOrange=cOrange;
		this.cGreen=cGreen;	
	}
	
	public void setToRed(){
		cRed.setFill(Color.RED);
		cOrange.setFill(Color.BLACK);
		cGreen.setFill(Color.BLACK);
	}
	
	public void setToGreen(){
		cRed.setFill(Color.BLACK);
		cOrange.setFill(Color.BLACK);
		cGreen.setFill(Color.GREEN);
	}
	
	public void setToOrange(){
		cRed.setFill(Color.BLACK);
		cOrange.setFill(Color.ORANGE);
		cGreen.setFill(Color.BLACK);
	}
	

}
