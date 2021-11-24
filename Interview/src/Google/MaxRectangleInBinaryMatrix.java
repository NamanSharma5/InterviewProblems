package Google;

import java.util.ArrayList;

public class MaxRectangleInBinaryMatrix {

  public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
    /* think of representation of A as list of rows
        1 0 0
        0 0 1   ->    [[1,0,0], [0,0,1]]

      Failed Idea (can find failing counter example) : longest row approach twice on normal grid and transposed grid
      longest row approach - find the longest row and see if you can grow it/ a subset in either direction (maintain current size & see if growing helps)

      BUT similar idea does work where you translate a binary grid into an equivalent form based on consecutive ones seen
      i.e: 1 0 0 1        1 0 0 1
           1 1 0 1        2 1 0 2
           0 0 1 1        0 0 1 3
           1 1 1 0        1 1 2 0

     */
    return 0;
  }

}
