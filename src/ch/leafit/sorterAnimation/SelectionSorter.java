package ch.leafit.sorterAnimation;

import javafx.application.Platform;

public final class SelectionSorter extends Thread {

	private int[] numbers;
	private Controller controller;
	private int speed;

	public SelectionSorter(Controller controller, int speed) {
		this.controller = controller;
		this.speed=speed;
		numbers = Tools.genArray(10);
		start();
	}

	public void run() {
		for (int i = 0; i < numbers.length - 1; i++) {
			int minIndex = i; // Index of smallest remaining value.
			for (int j = i + 1; j < numbers.length; j++)
				if (numbers[minIndex] > numbers[j])
					minIndex = j; // Remember index of new minimum
			if (minIndex != i) {
				display(numbers, i, i, minIndex);
				// Exchange current element with smallest remaining.
				int temp = numbers[i];
				numbers[i] = numbers[minIndex];
				numbers[minIndex] = temp;
			}
			display(numbers, i, i);
		}

		display(numbers, -1, -1);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				controller.enableDisplay();
			}
		});
	}

	private void display(final int[] ia, final int blue, final int current) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				controller.drawShapes(ia, blue, current);
			}
		});
		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void display(final int[] ia, final int blue, final int current, final int minIndex) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				controller.drawShapes(ia, blue, current, minIndex);
			}
		});
		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
