package ch.leafit.sorterAnimation;

import javafx.application.Platform;

public final class BubbleSorter extends Thread{
	
	private int[] numbers;
	private Controller controller;
	private int speed;
	
	public BubbleSorter(Controller controller, int speed){
		this.controller=controller;
		this.speed=speed;
		numbers=Tools.genArray(10);
		start();
	}

	public void run(){
		int n = numbers.length;
		int temp = 0;
		for (int i=0; i < n; i++) {
			for (int j=1; j<(n-i); j++) {
				if (numbers[j-1] > numbers[j]) {
					temp = numbers[j-1];
					numbers[j-1] = numbers[j];
					numbers[j] = temp;
				}
				display(numbers,n-i-1,j);
			}
		}
		display(numbers,-1,-1);
		Platform.runLater(new Runnable() {
			@Override
			public void run(){controller.enableDisplay();}
		});
	}
	
	private void display(final int[] ia, final int blue, final int current){
		Platform.runLater(new Runnable() {
			@Override
			public void run(){controller.drawShapes(ia, blue, current);}
		});
		try {Thread.sleep(speed);}
		catch (InterruptedException e) {e.printStackTrace();}
	}
}
