package MVC_Observer_Observable;

import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the controller element. it changes the value in the
 * model! each mouse-click increments the value by 1!
 **/

public final class Controller extends Button implements ActionListener {

	private static final long serialVersionUID = 1L;

	private static int c = 0;

	private Model myModel; // Reference to the model

	public Controller(Model mm, String s) {
		super(s);
		myModel = mm;
	}

	public void actionPerformed(ActionEvent ae) {
		try {
			myModel.changeValue(c++);
		} // inform the model of the changement
		catch (Exception m) {
			c = 0; // reset
			try {
				myModel.changeValue(c++);
			} catch (Exception e) {
			} // we can do this because c==0!!!
		}
	}
}
