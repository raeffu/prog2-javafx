package MVC_SliderSample;

import javax.swing.BoundedRangeModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public final class ConsoleView implements ChangeListener {

	private BoundedRangeModel m;
	
	public ConsoleView(BoundedRangeModel m){
		this.m = m;
		m.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent a) {System.out.println(m.getValue());}
}