package MVC_SliderSample;

import javax.swing.*;
import javax.swing.event.*;

public final class TextAdapter extends JTextField implements ChangeListener{
	
	private static final long serialVersionUID = 1L;
	private BoundedRangeModel model;
	
	public TextAdapter(BoundedRangeModel model) {
		this.model = model;
		model.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent arg0) {setText(""+model.getValue());}
}

