package MVC_Observer_Observable;

import java.awt.*;
import java.util.*;

public final class HistoView extends Canvas implements Observer {

	private static final long serialVersionUID = 1L;
	private Color backGround = Color.black;
	@SuppressWarnings("unused")
	private Color onColor;
	private Color color = backGround;

	private int w = 50;
	private int h = 100;

	private int actual_h = 0;

	public HistoView(Color c) { // c is the "On-Color"
		onColor = c;
		setSize(h, w);
	}

	public void update(Observable o, Object arg) {
		actual_h = ((Model) o).getValue();
		repaint();
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(0, 0, w, actual_h);
	}
}
