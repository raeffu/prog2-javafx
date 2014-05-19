package MVC_Observer_Observable;

import java.awt.*;
import java.awt.event.*;

public final class ApplicationFrame extends Frame {

	private static final long serialVersionUID = 1L;

	public ApplicationFrame() {

		super("MVC Demonstration");

		setLayout(new FlowLayout());
		setBackground(Color.yellow);

		// Our model !!!!!!!!!!!
		Model myModel = new Model();

		// Some views !!!!!!!!!!
		LabelView l1 = new LabelView("         ");
		OtherLabelView v1 = new OtherLabelView("         ");
		HistoView vv1 = new HistoView(Color.blue);
		ConsoleView cv1 = new ConsoleView();

		// Our controller !!!!!!!!
		Controller b1 = new Controller(myModel, "Controller: Klick");

		add(l1);
		add(v1);
		add(vv1);

		// Register the views
		myModel.addObserver(l1);
		myModel.addObserver(v1);
		myModel.addObserver(vv1);
		myModel.addObserver(cv1);

		add(b1);
		b1.addActionListener(b1);

		// to close the frame properly
		addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent event) {System.exit(0);}
			}
		);
	}

}
