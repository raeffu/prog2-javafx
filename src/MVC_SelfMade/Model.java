package MVC_SelfMade;

import java.util.*;

public final class Model {

	private int x = 0;
	private Vector<View> lst = new Vector<View>();

	public void change(int x) {
		this.x = x;
		notifyListener();
	}

	public int getX() {return x;}

	@SuppressWarnings("unchecked")
	private void notifyListener() {
		Vector<View> copyLst = ((Vector<View>) lst.clone());
		for (int i = 0; i < copyLst.size(); i++) ((View) copyLst.elementAt(i)).react();
	}

	public void addView(View v){lst.add(v);}
	public void removeView(View v){lst.remove(v);}
}