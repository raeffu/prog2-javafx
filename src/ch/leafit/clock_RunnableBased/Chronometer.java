package ch.leafit.clock_RunnableBased;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;

public final class Chronometer implements Runnable {

	private Label display;

	public Chronometer(Label display) {this.display = display;}

	private int hsec, seconds, minutes, hours;
	private String result;
	private boolean noDisplay = false;
	private boolean stopIt = false;

	public void enableDisplay() {noDisplay = false;}
	public void disableDisplay() {noDisplay = true;}
	public boolean isDisplayOn() {return !noDisplay;}
	public void stopIt() {stopIt = true;}

	private void increment() {
		hsec++;
		if (hsec >= 100) {
			hsec = 0;
			seconds++;
		}
		if (seconds >= 60) {
			seconds = 0;
			minutes++;
		}
		if (minutes >= 60) {
			minutes = 0;
			hours++;
		}
		if (hours >= 24)
			hours = 0;
	}

	private void refreshDisplay() {
		result = hours + ":" + minutes + ":" + seconds + ":" + hsec;
	}

	@Override
	public void run() {

		while(true) {
			if (stopIt) break;
			increment();
			refreshDisplay();
			if(!noDisplay) {
				// Update JavaFX UI with runLater() in UI thread
				Platform.runLater(new Runnable() {
					@Override
					public void run(){display.setText("" + result);}
				});
			}
			try{Thread.sleep(10);}
			catch (InterruptedException ex) {
				Logger.getLogger(Chronometer.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
