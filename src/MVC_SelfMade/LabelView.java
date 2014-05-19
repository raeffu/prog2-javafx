package MVC_SelfMade;

import java.awt.*;

public final class LabelView extends Label implements View {

	private static final long serialVersionUID = 1L;
	private Model m;
	private int myValue = 0;

	public LabelView(Model m, String s) {
		super(s);
		this.m = m;
	}

	public void react() {
		myValue = ((Model) m).getX();
		this.setText("" + myValue);
	}
}