package MVC_SliderSample;

import java.awt.*;
import javax.swing.*;

public final class SliderFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public SliderFrame(){
		super(" MVC Sample ");
		
		BoundedRangeModel model = new DefaultBoundedRangeModel(0, 0, 0, 100);
		JSlider slider = new JSlider(model);
		
		JPanel show = new JPanel();
		show.setLayout(new GridLayout(4,1));
		
		ProgressBarAdapter pbv = new ProgressBarAdapter(model);
		LabelAdapter vi = new LabelAdapter(model);
		JProgressBar jpb= new JProgressBar(model);
		TextAdapter ta = new TextAdapter(model);
		new ConsoleView(model);
		
		show.add(vi);
		show.add(pbv);
		jpb.setStringPainted(true);		
		show.add(jpb);
		show.add(ta);
		
		getContentPane().add(slider, BorderLayout.SOUTH);		
		getContentPane().add(show, BorderLayout.CENTER);
		pack();
	}
}