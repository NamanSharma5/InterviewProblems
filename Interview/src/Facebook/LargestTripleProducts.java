package Facebook;

public class LargestTripleProducts {
  // Heaps

  static int[]  findMaxProduct(int[] arr) {

    // find max three numbers in a growing list! - Can do this in O(n) from gut feeling; just need a data structure to hold largest 3 numbers seen yet & access/ update in constant time
    /*
      three item array : which requires two comparisons but only works since 3 max 3 items need to kept track of
       Steps:
       -- init solution array
       -- init max3 arrays w/ 0s
       -- setup a for loop to run through input array
       -- for first 2 elems - need to return -1
       -- write function to update max3 arrays for each current value & function to multiply all 3 values


       Heap structure
     */

    int[] solution = new int[arr.length];
    int[] largest3 = new int[] {0,0,0};

    for(int i = 0; i < arr.length ;i ++){
      updateMax3(largest3,arr[i]);
      if(i == 0 || i == 1){
        solution[i] = -1;
      }else{
        solution[i] = multiplyMax3(largest3);
      }
    }
    return solution;
  }

  static void updateMax3(int[] input,int current){
    // largest3 = [max, mid, min]
    if(current > input[1]){
      if(current > input[0]){
        //[current, old max, old min]
        input[2] = input[1];
        input[1] = input [0];
        input[0] = current;
      }else{
        // [old max, current, old mid]
        input[2] = input[1];
        input[1] = current;
      }
    }else{
      // [old max, old mid, current]
      if(current > input[2]){
        input[2] = current;
      }
    }
  }

  static int multiplyMax3(int[] input){
    // input array must be of length 3
    return input[0] * input [1] * input[2];
  }

  public static void main(String[] args) {
    int[] arr_1 = {2, 4, 7, 1, 5, 3};
    int[] output = findMaxProduct(arr_1);
  }

}
