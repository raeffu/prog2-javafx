package MVC_SelfMade;

import java.awt.*;

public final class OtherView extends Label implements View {

	private static final long serialVersionUID = 1L;
	private int myValue = 0;
	private Model m;

	public OtherView(Model m, String s) {
		super(s);
		this.m = m;
		this.setBackground(Color.blue);
	}

	public void react() {
		myValue = ((Model) m).getX();
		this.setText("" + (myValue * 10));
	}
}