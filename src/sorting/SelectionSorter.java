package sorting;

import javafx.application.Platform;

public final class SelectionSorter extends Thread {

  private MainController _controller;
  private int _speed;

  private int[] _numbers;

  public SelectionSorter(MainController controller, int speed) {
    _controller = controller;
    _speed = speed;

    _numbers = Tools.genArray(10);
    start();
  }

  @Override
  public void run() {
    selectionSort(_numbers);
  }

  private void selectionSort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      int minIndex = i; // Index of smallest remaining value.
      for (int j = i + 1; j < nums.length; j++)
        if (nums[minIndex] > nums[j])
          minIndex = j; // Remember index of new minimum
      if (minIndex != i) {
        // Exchange current element with smallest remaining.
        int temp = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = temp;
        
        this.display(nums, minIndex, i);
      }
    }
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
