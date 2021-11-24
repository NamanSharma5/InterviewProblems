package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
  // return power set of unique integer array
  /*
  Overview:
  Suppose solution to [1] is [[],[1]]
  & solution to [2] is [[],[1],[2],[1,2]] -- i.e. duplicate set of solutions for 1 less & add new item to each list in solution arrya

   */
  public static List<List<Integer>> subsets(int[] nums) {
    return subsetsHelper(nums);
  }

  public static List<List<Integer>> subsetsHelper (int[] nums){

    if(nums.length == 0){
      ArrayList<List<Integer>> tempList = new ArrayList();
      tempList.add(new ArrayList<>());
      return tempList;
    }

    int last = nums[nums.length - 1];
    int[] newNums = new int[nums.length - 1];
    for(int i = 0; i < newNums.length; i++ ){
      newNums[i] = nums[i];
    }

    // problem with this solution is that it adds the current number to all lists, so you never have intermediate singletons
    List<List<Integer>> tempSolution = subsetsHelper(newNums);
    tempSolution.forEach(list->list.add(last));
    List<List<Integer>> finalSolution = subsetsHelper(newNums);
    finalSolution.addAll(tempSolution);

    return finalSolution;
  }

  public static void main(String[] args) {
    List<List<Integer>> subsets = subsets(new int[]{3,4,5});
    System.out.println(subsets);
  }
}
