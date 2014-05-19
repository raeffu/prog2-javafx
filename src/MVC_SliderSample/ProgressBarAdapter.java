package MVC_SliderSample;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public final class ProgressBarAdapter extends JPanel {

	private static final long serialVersionUID = 1L;

	public ProgressBarAdapter(BoundedRangeModel m) {
		this.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(),
				"Progrss", 0, 0, new Font("Dialog", Font.BOLD, 12)));
		this.setLayout(new BorderLayout());
		JProgressBar jpb = new JProgressBar(m);
		jpb.setBounds(0, 0, 100, 10);
		jpb.setMinimum(0);
		jpb.setMaximum(100);
		jpb.setValue(0);
		jpb.setStringPainted(true);
		this.add("North", jpb);
	}
}