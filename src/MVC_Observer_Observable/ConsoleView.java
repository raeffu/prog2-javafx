package MVC_Observer_Observable;

import java.util.*;

/**
 * This class is a typical view element. An instance of it has to be registered
 * by the model! The model will call the update-method if it changes! These
 * views have automatically access to the model by the form of the update
 * method!!!!!!
 **/
public final class ConsoleView implements Observer {

	private int myValue = 0;

	public void update(Observable o, Object arg) {
		myValue = ((Model) o).getValue();
		System.out.println("" + myValue);
	}
}