package Facebook;

public class ContiguousSubarrays {

  static int[] countSubarrays(int[] arr) {
    /*
    Naive O(n^2) solution:
    - Go through each item in input array
    - Set-up variable to keep track of adjacent smaller numbers (init = 1)
    - check left indicies consecutively counting down
    - check right indicies consecutively counting up
     */

//    int[] solution = new int[arr.length];
//
//    for(int i = 0; i < arr.length; i++){
//      int totalAdjacentArrays = 1;
//
//      //first check left
//      int pointer = i - 1;
//      while((pointer >= 0) && (arr[pointer] < arr[i])){
//        totalAdjacentArrays ++;
//        pointer --;
//      }
//
//      //now check to the right
//      pointer = i + 1;
//      while((pointer < arr.length) && (arr[pointer] < arr[i])){
//        totalAdjacentArrays ++;
//        pointer++;
//      }
//      solution[i] = totalAdjacentArrays;
//    }
//
//    return solution;

    /* Efficient Solution in 0(n)
      Using hints:

      consider L[i] = no of valid subarrays ending @ i
      consider R[i] = no of valid subarrays starting @ i
      solution = L[i] + G[i] - 1 (-1 because we include itself twice)

      G[i] = Reverse Array & calculate L[arr.length - i - 1]

      L[i] can be calculated from L[i-1] - i.e if arr[i] > arr[i-1] then L[i] = L[i+1] else L[i] = 1

     */

    return null;
  }

  public static void main(String[] args) {
    int[] test_1 = {3, 4, 1, 6, 2};
    System.out.println(countSubarrays(test_1).toString());
  }

}
