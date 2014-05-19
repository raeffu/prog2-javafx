package MVC_SelfMade;

import java.awt.*;
import java.awt.event.*;

public final class ApplicationFrame extends Frame {

	private static final long serialVersionUID = 1L;

	public ApplicationFrame() {

		super("MVC Demonstration");

		setLayout(new FlowLayout());
		setBackground(Color.yellow);

		// Our model !!!!!!!!!!!
		Model model = new Model();

		// Some views !!!!!!!!!!
		LabelView l1 = new LabelView(model, "    ");
		OtherView v1 = new OtherView(model, "    ");
		HistogrammView vv1 = new HistogrammView(model, Color.blue);
		ConsoleView cv1 = new ConsoleView(model);

		// Our controller !!!!!!!!
		Controller controller = new Controller(model, "Controller");

		add(l1);
		add(v1);
		add(vv1);

		// Register the views
		model.addView(l1);
		model.addView(v1);
		model.addView(vv1);
		model.addView(cv1);

		add(controller);
		controller.addActionListener(controller);

		// to close the frame properly
		addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent event) {System.exit(0);}
			}
		);
	}

}