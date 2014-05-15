package sorting;

import java.util.Random;

public class Tools {

  private Tools(){}
  
  public static int[] genArray(int n) {
    Random rand = new Random();

    int[] ia = new int[n];
    for (int i = 0; i < n; i++)
      ia[i] = Math.abs(rand.nextInt() % 200);
    return ia;
  }
}
