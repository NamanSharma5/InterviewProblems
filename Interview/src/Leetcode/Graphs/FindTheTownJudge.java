package Leetcode.Graphs;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FindTheTownJudge {
  public static int findJudge(int n, int[][] trust) {
    // first array refers to the number of sub arrays & tells us that the subarrays are of type int[]
    // consider graph: no of inward edges - no of outward edges = N - 1

    // no of inward edges - outward edges
    int[] count = new int[n+1]; // technically count[0] never used

    for(int i = 0; i < trust.length; i++){
      count[trust[i][0]] --;
      count[trust[i][1]] ++;
    }
    for(int i = 1; i < n + 1;i++){
      if(count[i] == n-1) return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    int [][] test = {{1,3},{1,4},{2,3},{2,4},{4,3}};
    findJudge(4,test);
  }

/* Not cleanest solution even if it works

  if(n==1){
    return 1;
  }
  // Solution with O(n) time complexity and O(n) space complexity using Hashmap

  HashMap<Integer, Integer> map = new HashMap<>();

  for(int i = 0; i < trust.length; i++){
    int personBeingTrusted = trust[i][1];
    int trustCount = map.containsKey(personBeingTrusted) ? map.get(personBeingTrusted) : 0;
    map.put(personBeingTrusted,trustCount + 1);
  }

  for(int i = 0; i < trust.length; i++){
    int personTrusting = trust[i][0];
    if(map.containsKey(personTrusting)){
      map.remove(personTrusting);
    }
  }

  Integer possibleJudges = 0;
  Integer judgeNumber = 0;
  if(map.containsValue(n - 1)){ // can't trust yourself
    for(Map.Entry<Integer,Integer> current: map.entrySet()){
      if(current.getValue() == n-1) {
        possibleJudges = possibleJudges + 1;
        judgeNumber = current.getKey();
      }
      if(possibleJudges > 1) return -1;
    }
    return judgeNumber;
  }else {
    return -1;
  }
*/

/*
  Doesn't work ! - Example case [[1,2] , [2,3]] since 3 is not trusted by everybody (specifically 1)

    Set<Integer> trusting = new HashSet<>();
    Set<Integer> trusted = new HashSet<>();

    for(int i = 0; i < trust.length; i++){
      int[] current = trust[i];
      trusting.add(current[0]);
      trusted.add(current[1]);
    }

    trusted.removeAll(trusting);
    return trusted.stream().findFirst().orElse(-1);
*/

/*  Traversal of array

  for(int i = 0; i < trust.length; i++){
      System.out.println("\n");
      for (int j = 0; j < trust[i].length; j++){
        System.out.print(trust[i][j] + ", ");
      }
    }*/
}
