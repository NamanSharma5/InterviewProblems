package Ocado;

import java.util.Arrays;

public class MakeAllArrayElementSame {
  /*
     - Find average of array as this will require least changes to numbers  as nearest to all numbers
     - number of step to get to average

   */
  public static int solution(int[] A) {
    int total = Arrays.stream(A).sum();
    System.out.println("total: " + total);
    System.out.println("Length: " + A.length);

    int average = Math.round((float)total / A.length);
    int steps = 0;

    for(int i = 0; i < A.length; i++){
      int diff = Math.abs(A[i] - average);
      steps = (diff != 0) ? steps + diff : steps;
    }
    return steps;
  }

  public static void main(String[] args) {
    int[] array = {3,2,1,1,2,3,1};
    int[] array2 = {4,1,4,1};
    int[] array3 = {3,3,3};
    solution(array3);
  }

}
