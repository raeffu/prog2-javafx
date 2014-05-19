package MVC_SelfMade;

import java.awt.*;
import java.awt.event.*;

public final class Controller extends Button implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static int c = 0;
	private Model m;

	public Controller(Model mm, String s) {
		super(s);
		m = mm;
	}

	public void actionPerformed(ActionEvent ae) {
		m.change(c++);
		if (c == 40) c = 0;
	}
}