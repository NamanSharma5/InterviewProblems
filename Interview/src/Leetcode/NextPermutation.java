package Leetcode;

import java.util.Arrays;

public class NextPermutation {
  /* Overview:
      Rearrange numbers into the next lexicographically greater permutation of numbers
      i.e: [1,2,3] -> [1,3,2] -> [3,1,2] ->   ; [1,1,5] -> [1,5,1]

      if not possible i.e [3,2,1] rearrange to lowest possible order -> [1,2,3]
   */

  public static void nextPermutation(int[] nums) {
    // check for first index at which right to left array is not sorted
    int i = nums.length - 1;
    while(i-1 >0 && nums[i-1] >= nums[i]){
      i--;
    }
    // set i = the greatest index to break reverse sorted order
    i = i-1;
    if(i == 0){
      reverse(nums,0,nums.length-1);
      return;
    }
    int j = nums.length - 1;
    while(nums[i] < nums[j] && i < j){
      j--;
    }
    swap(nums,i,j);
    reverse(nums,i++,nums.length - 1);
  }


  public static void reverse(int[] nums,int start, int end){
    while(start != end){
      swap(nums,start,end);
      start++;
      end--;
    }
  }

  public static void swap(int[] nums, int a, int b){
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6};
    reverse(nums,1,5);
    System.out.println("done");
  }
}


/* The below algorithm passed the test cases but was incorrect in its overall approach hence failed hidden test cases */
/*
      recursively look for the largest element and see if it can be swapped with the item to its left iff it is greater than item to left
      if not, then look for second largest & so on, unless everything cannot be swapped, in which case return ordered list
 */
//  public static void nextPermutation(int[] nums) {
//    int attempts = 0;
//
//    while(attempts < nums.length){
//      // get index of (attempts + 1)th item
//      int indexOfNthLargestItem = positionOfNthLargestIndex(nums,attempts + 1);
//      if(indexOfNthLargestItem > 0 && nums[indexOfNthLargestItem - 1] < nums[indexOfNthLargestItem]){
//        int temp = nums[indexOfNthLargestItem];
//        nums[indexOfNthLargestItem] = nums[indexOfNthLargestItem - 1];
//        nums[indexOfNthLargestItem - 1] = temp;
//        return;
//      }
//      attempts++;
//    }
//    //Maximum Lexicographic Order
//    Arrays.sort(nums);
//  }
//
//  public static int positionOfNthLargestIndex(int[] nums,int Nth){
//    int[] sorted = Arrays.copyOfRange(nums,0,nums.length);
//    Arrays.sort(sorted);
//    int nthLargestValue = sorted[nums.length - Nth];
//    for(int i = 0; i < nums.length; i++){
//      if(nums[i] == nthLargestValue){
//        return i;
//      }
//    }
//    return -1;
//  }