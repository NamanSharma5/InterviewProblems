package Leetcode.Arrays;

public class SearchRotatedSortedArray {

  public int search(int[] nums, int target) {
    // problem sorted array pivoted about certain point, looking for index of a number in array / -1 if not in it

    // if array was sorted - binary search i.e recursive solution
    // but array has been rotated at some point

    // first approach:
    // step1 : compare two consecutive numbers to find the rotation point - how do I know whether to go left or right tho !!
    // step2: compare value with rotaion point & perform binary search on left/right half of list

    //step1:
    int rotationPoint = findRotationPoint(nums);
    return 0;
  }
  private int findRotationPoint(int[] nums){
    int first = nums.length / 2;
    int second = first + 1;
    if(nums[first] > nums[second]){
      //return
    }
    return 0;
  }
}
