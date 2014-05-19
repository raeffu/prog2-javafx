package MVC_SelfMade;

import java.awt.*;

public final class HistogrammView extends Canvas implements View {

	private static final long serialVersionUID = 1L;
	private Color backGround = Color.black;

	@SuppressWarnings("unused")
	private Color onColor;
	private Color color = backGround;
	private int w = 50;
	private int h = 100;
	private int actual_h = 0;
	private Model m;

	public HistogrammView(Model m, Color c) {
		this.m = m;
		onColor = c;
		setSize(h, w);
	}

	public void react() {
		actual_h = ((Model) m).getX();
		repaint();
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(0, 0, w, actual_h);
	}
}