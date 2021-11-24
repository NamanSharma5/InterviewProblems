package Citadel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaysToSum {

  public static int ways(int total, int k) {
    // first generate array to pass into Combination Sum Function
    int[] candidateValues = new int[k];
    for (int i = 0; i < k ; i++){
      candidateValues[i] = i+1;
    }
    List<List<Integer>> solutionSet = combinationGenerator(candidateValues,total);
    return solutionSet.size();
  }

  private static List<List<Integer>> combinationGenerator(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
  }

  private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{
      for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(ways(4,2));
  }
}
