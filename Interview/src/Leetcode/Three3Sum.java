package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Three3Sum {
  // in an array to find all triplets of indicies, whose values sum to 0
  /* Idea 1  0(n^3)

   */

  /* Idea 2  0(n?)  - derived from how to solve 2 sum but for any target using hashmap
    Suppose solving for 2Sum:
    - init solution list
    - go through list of integers O(n) & add everything as key with indicies as values
    - join lists of indicies of negative & positive keys of same number & order solution by
    - Go through all keys in hashmap & for the values  join all +ve with -ve

   */

  // twoSum = indicies of array items which sum to target
  public static int[] twoSum(int[] nums,int target) {
    /* naive solution O(n^2)
    for (int i = 0; i < nums.length; i++){
      int newTarget = target - nums[i];
      for (int j = i+1; j < nums.length; j++ ){
        if (nums[j] == newTarget){
          System.out.println(i + "  "+ j);
          return new int[]{i, j};
        }
      }
    } */

    // Hashmap -- O(n)
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    for(int i = 0; i < nums.length ; i++ ){
      if(map.containsKey(nums[i])){
        ArrayList values = map.get(nums[i]);
        values.add(i);
        map.put(nums[i],values);
      }else{
        map.put(nums[i],new ArrayList<>(List.of(i)));
      }
    }
    for(int i = 0; i < nums.length; i++){
      int newTarget = target - nums[i];
      // remove nums[i] itself from the hasmap
      if(map.containsKey(newTarget)){
        // 2 cases: 1) newTarget = current value - in this case over 2 occurences required
        // 2) newTarget cannot be number itself
        if((nums[i] == newTarget && map.get(newTarget).size() > 1) ||
        !map.get(newTarget).contains(i)){
          int index1 = map.get(nums[i]).remove(0);
          int index2 = map.get(newTarget).remove(0);
          return new int[]{index1,index2};
        }
      }
    }


    //  Given Sorted List - o( n log n ) ##adjust l/r pointer ## ONLY WORKS GIVEN SORTED ARRAY
   /* int leftPointer = 0;
    int rightPointer = nums.length - 1;
    while (leftPointer < rightPointer){
      int sum = nums[leftPointer] + nums[rightPointer];
      if(sum == target){
        System.out.println(leftPointer +" "+rightPointer);
        return new int[]{leftPointer,rightPointer};
      }else if(sum < target){
        leftPointer ++;
      }else{
        rightPointer --;
      }
    }*/




    return null;
  }

  public List<List<Integer>> threeSum(int[] nums) {
    // use the twoSum solution in O(n) to implement threeSum
    // would take o(n^2)
    /*
    Approach:
    -loop through list & pass in remainder of list with new target (-x)
    - concat solution w/ current index
    - may have to check if duplicate solutions
    */

    return null;
  }
  public static void main(String[] args) {
    Three3Sum test = new Three3Sum();
    System.out.println(twoSum(new int[]{3,2,4},6));
  }
}


