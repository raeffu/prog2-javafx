package sorting;

import javafx.application.Platform;

public final class BubbleSorter extends Thread {

  private MainController _controller;
  private int _speed;

  private int[] _numbers;

  public BubbleSorter(MainController controller, int speed) {
    _controller = controller;
    _speed = speed;

    _numbers = Tools.genArray(10);
    start();
  }

  @Override
  public void run() {
    int n = _numbers.length;
    int temp = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 1; j < (n - i); j++) {
        if (_numbers[j - 1] > _numbers[j]) {
          temp = _numbers[j - 1];
          _numbers[j - 1] = _numbers[j];
          _numbers[j] = temp;
        }
        display(_numbers, n - i - 1, j);
      }
    }
    display(_numbers,-1,-1);
    Platform.runLater(new Runnable() {
      @Override
      public void run() {_controller.enableElements();}
    });
  }

  private void display(final int[] ia, final int blue, final int current) {
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        _controller.drawShapes(ia, blue, current);
      }
    });
    try {
      Thread.sleep(_speed);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
