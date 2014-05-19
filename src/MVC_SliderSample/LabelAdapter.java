package MVC_SliderSample;

import javax.swing.*;
import javax.swing.event.*;

public final class LabelAdapter extends JLabel implements ChangeListener{

	private static final long serialVersionUID = 1L;
	private BoundedRangeModel m;

	public LabelAdapter(BoundedRangeModel m){
		this.m = m;
		m.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent a) {setText("" + m.getValue());}
}