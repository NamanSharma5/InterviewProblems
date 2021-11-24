package DRW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleMissingRolls {

  public int[] solution(int[] A, int F, int M) {
    // A= array of remembered roll results ; F = number of forgotten rolls & M = Aritmetic mean of all results
    /*
    Overview:
    Total = (A.length + F) * M
    SumOfForgotten = Total - SumOfA

    Is it possible using numbers 1 - 6 F times to get to SumOfForgotten
     */

    int sumOfAllRollResults = (A.length + F) * M;
    int sumOfForgottenRolls =  sumOfAllRollResults - Arrays.stream(A).sum();
    int[] candidateValues = {1,2,3,4,5,6};

    List<List<Integer>> solution = combinationSum(candidateValues,sumOfForgottenRolls);
    for(int i =0; i < solution.size(); i++){
      List<Integer> current = solution.get(i);
      if(current.size() == F){
        int[] solutionArray = new int[F];
        for(int j = 0; j < F; j++){
          solutionArray[j] = current.get(j);
        }
        return solutionArray;
      }
    }
    return new int[]{0};
  }

  private static List<List<Integer>> combinationSum(int[] nums, int target) {
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

    int[] candidateValues = {1,2,3,4,5,6};
    List<List<Integer>> solution = combinationSum(candidateValues,9);
    System.out.println("done");

  }
}
