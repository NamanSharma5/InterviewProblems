package Leetcode.Backtracking;

import java.util.*;

/* Problem Overview:
array of distinct integers "candidates" and the various unique combinations of candidates that sum to target

i.e: candidates = [2,3,6,7] target = 7
possibilities : [[2,3,3],[7]]

Some Approaches:

Some form of dynamic programming or recursion would be simplest to setup:

1)
 - Perhaps using each item only once to see if that generates any solutions
 - then using each item up to twice and see if that generates solutions
Don't think this works as how do i get from case of using each item once to each item twice (not simple at least)

2)
 - Call helper function on target minus each candidate value - if solution exists then pull solution set and value to all

 i.e helper(candidates, 5) ; helper(candidates, 4) ; helper(candidates, 1)  ;helper(candidates, 0)
 */

public class CombinationSum {
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    Set<List<Integer>> solutionSet = new HashSet<>();
    combinationSumHelper(candidates,target,solutionSet);
    List<List<Integer>> solutionList=  new ArrayList<>(solutionSet);
    return solutionList;

  }

  public static Optional<List<List<Integer>>> combinationSumHelper(int[] candidates,int target,Set<List<Integer>> solution){
    if(target < 0){
      return Optional.empty();
    }

    for(int i = 0; i < candidates.length; i++){

      //base cases
      if(target == candidates[i]){
        List<Integer> partSolution = new ArrayList<>(List.of(target));
        List<List<Integer>> partSolutionList = new ArrayList<>(List.of(partSolution));
        return Optional.of(partSolutionList);
      }

      Optional<List<List<Integer>>> possibleSolution = combinationSumHelper(candidates,target-candidates[i], solution);
      if(possibleSolution.isPresent()){
        int finalI = i;
        possibleSolution.get().forEach(list -> list.add(candidates[finalI]));
        solution.addAll(possibleSolution.get());
      }
    }

    return Optional.empty();
  }


  public static void main(String[] args) {
    int[] candidates = {2,3,6,7};
    Integer target = 7;
    System.out.println(combinationSum(candidates,target));
  }

//  public static Set<List<Integer>> combinationSumHelper(int[] candidates, int target, Set<List<Integer>> currentSolution) {
//
//    if(target < 0){
//      return new HashSet<>();
//    }
//
//
//    for(int i = 0; i < candidates.length; i++){
//
//      if(target % candidates[i] == 0){ //if any multiple of current item = target
//        List<Integer> tempList = new ArrayList<>();
//        for(int j = 0; j < (target / candidates[i]); j++){
//          tempList.add(candidates[i]);
//        }
//        Set<List<Integer>> solutionWithoutTargetCandidateMultiples = combinationSumHelper(candidates,target,currentSolution);
//        solutionWithoutTargetCandidateMultiples.forEach(list -> list.addAll(tempList));
//        currentSolution.addAll(solutionWithoutTargetCandidateMultiples);
//      }
//      else if(!combinationSumHelper(candidates,target - candidates[i],currentSolution).isEmpty()){
//        int finalI = i;
//        Set<List<Integer>> solutionWithoutTargetCandidate = combinationSumHelper(candidates,target - candidates[i],currentSolution);
//        solutionWithoutTargetCandidate.forEach(list -> list.add(candidates[finalI]));
//        currentSolution.addAll(solutionWithoutTargetCandidate);
//      }
//    }
//    return currentSolution;
//  }

}
