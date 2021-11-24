package Leetcode.Arrays;

public class MinimumInRotatedSortedArray {

  // essentially find the point where two consecutive numbers are decreasing
  // this would only happen once & the following number is the min

  /* must run in O(log n)
  -binary search but to identify a decrease in consecutive items
  - how do we know which direction to go in ?
  - potentially compare first and last number of the chunks (i.e half of the remaining list and if last < first then look there
  */
  public static int findMin(int[] nums) {

    // idea is to look at chunk of array & compare first with last item in chunk; if last < first then answer in chunk!
    // else answer in a different chunk
    // So original implementation Doesn't work on counter example == [1,0,2,3,4,5,6,7]
    // But the below implementation using mid to help with moving to new chunk works well

    // Variation on Binary search
    int left = 0;
    int right = nums.length - 1;

    while(left < right){
      int mid = (left + right) / 2;
      if(nums[right] < nums[mid]){
        left = mid + 1;
      }else{
        right = mid;
      }
    }

    return nums[right];


    // Alternate Approach - using two pointers, where you have left and right with r-l doubling each time until value at right < left
    // difficult to implement because hard to find termination condition
  }

  public static void main(String[] args) {
    int[] vals = {11,13,15,17};
    int min = findMin(vals);
    System.out.println(min);
  }

}
