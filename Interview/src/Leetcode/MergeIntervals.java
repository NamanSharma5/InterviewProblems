package Leetcode;

public class MergeIntervals {
  /*
  Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
  and return an array of the non-overlapping intervals that cover all the intervals in the input.
   */

  public int[][] merge(int[][] intervals) {
    /*
    Approach O(n):
    Traverse through list of intervals; if lower value of consecutive interval (interval n+1) is greater than smallest value
    of interval n-1 & smaller than largest value of interval n-1 then merge intervals & create new interval
    with smallest value from n-1 & largest value from n+1
     */

    return null;

  }
}
