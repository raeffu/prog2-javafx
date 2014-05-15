package ch.leafit.startstop.sample2;

import java.util.Date;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

public final class A extends Thread {

	private String id;
	private boolean stopTheThread = false;
	private TextArea txaDisplay;

	public A(String id, TextArea txaDisplay) {
		this.id = id;
		this.txaDisplay = txaDisplay;
		start();
	}

	public void run() {
		while (!stopTheThread) {
			try {
				// Update JavaFX UI with runLater() in UI thread
				Platform.runLater(new Runnable() {
					public void run() {
						txaDisplay.appendText("\nHello I'm " + id);
						txaDisplay.appendText("\nCurrent time is: "+ new Date());
						if (Thread.interrupted()) {
							// We've been interrupted: no more working.
							txaDisplay.appendText("\nInterruption ...");
							stopTheThread = true;
						}
					}
				});
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				// If the thread is interrupted while sleeping
				stopTheThread = true;
				// Update JavaFX UI with runLater() in UI thread
				Platform.runLater(new Runnable() {
					public void run() {txaDisplay.appendText("\n" + id+ " is ending - by interruption");}
				});
			}
		}
	}
}
