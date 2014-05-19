package MVC_Observer_Observable;

import java.awt.*;
import java.util.*;

/**
 * This class is a typical view element. An instance of it has to be registered
 * by the model! The model will call the update-method if it changes! These
 * views have automatically access to the model by the form of the update
 * method!!!!!!
 **/
public final class OtherLabelView extends Label implements Observer {

	private static final long serialVersionUID = 1L;
	private int myValue = 0;

	public OtherLabelView(String s) {
		super(s);
		this.setBackground(Color.blue);
	}

	public void update(Observable o, Object arg) {
		myValue = ((Model) o).getValue();
		this.setText("" + (myValue * 10));
	}
}