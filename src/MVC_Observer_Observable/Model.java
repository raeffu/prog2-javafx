package MVC_Observer_Observable;

import java.util.*;

public final class Model extends Observable {
	
	private int value = 0;

	public Model() {super();}

	public void changeValue(int newValue) throws Exception {
		if (newValue >= 0 & newValue <= 10) {
			value = newValue;
			setChanged();
			this.notifyObservers();
		}
		else throw new Exception("value not in intervall 0..10!");
	}

	public int getValue() {return value;}
}
