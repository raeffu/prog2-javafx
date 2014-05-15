package ch.leafit.trafficlight.auto;

import javafx.application.Platform;

public final class Worker extends Thread{
	
	private StateEngine stateEngine;
	private DisplayManager displayManager;
	private ch.leafit.trafficlight.auto.State state;
	
	public Worker(StateEngine stateEngine, DisplayManager displayManager){
		this.stateEngine=stateEngine;
		this.displayManager=displayManager;
		start();
	}
	
	public void run() {
		while (true) {
			state = stateEngine.nextState();
			try{Platform.runLater(new Runnable() {
					public void run() {
						if(state == ch.leafit.trafficlight.auto.State.Green) displayManager.setToGreen();					
						if(state == ch.leafit.trafficlight.auto.State.Red) displayManager.setToRed();
						if(state == ch.leafit.trafficlight.auto.State.Orange) displayManager.setToOrange();
					}
				});
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {}
		}
	}
}
