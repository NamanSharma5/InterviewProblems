package Google;

import java.util.*;
import java.util.stream.Collectors;

public class MinDistanceFromNecessities {

  public int minDistance(List<HashMap<String, Boolean>> blocks, List<String> necessities) {
    // Pre-condition: each block has a reference to at least all necessities

    // Sliding Window Approach - O(n) time complexity
    /*
    Check if window has all the necessities & keep track of window with smallest size/ left&right of this window
      -> return (left+right)/2

     if current window doesn't have all necessities - right ++
     if current window has all necessities - left++
     */

    int left = 0;
    int right = 0;

    ArrayList<Integer> solutionWindows = new ArrayList<>(); // every 2 elements represent left/right of window i.e [1,3,2,3] -> [1,3] || [2,3]

    boolean isValidWindow = false;
    //keep track of times necessities seen in block -- note looping through necessities is constant as input varies over blocks
    HashMap<String,Integer> necessitiesMap = new HashMap<>();
    for(String s:necessities){
      necessitiesMap.put(s,0);
    }

    while(!(right == blocks.size() - 1 && !isValidWindow)){ //only terminate if right is at end & window is not valid
      if(!isValidWindow){
        right++;
        blocks.get(right).forEach((k,v)->{
          if(v){
            necessitiesMap.put(k,necessitiesMap.get(k) + 1);
          }
        });
      }else{
        solutionWindows.add(left);
        solutionWindows.add(right);
        blocks.get(left).forEach((k,v)->{
          if(v){
            necessitiesMap.put(k,necessitiesMap.get(k) - 1);
          }
        });
        left++;
      }
      isValidWindow = !necessitiesMap.containsValue(0);
    }

    int smallestSize = blocks.size();
    int middleOfSmallestWindow = 0;
    for(int i = 0; i < solutionWindows.size();i = i+2){
      int currentWindowSize = solutionWindows.get(i+1) - solutionWindows.get(i);
      if(smallestSize > currentWindowSize){
        smallestSize = currentWindowSize;
        middleOfSmallestWindow = (solutionWindows.get(i+1) + solutionWindows.get(i)) / 2;
      }
    }

    return middleOfSmallestWindow;
  }

}
    // O(n^2) as I have to look backwards and forwards of current index to find all necessities
    // iterate through all blocks and store distance of furthest necessity; return block with least furthest necessity
/*

  public int minDistance(List<HashMap<String,Boolean>> blocks, List<String> necessities) {
    // Pre-condition: each block has a reference to at least all necessities

    List<Integer> furthestNecessityFromBlocks = new ArrayList<>();
    for(int current = 0; current < blocks.size(); current++){

      // find furthest distance of necessity from current
      int finalCurrent = current;
      List<Integer> distances = necessities.stream()
              .map(necessity -> furthestDistanceNecessity(finalCurrent,necessity,blocks))
              .collect(Collectors.toList());

      Integer furthestNecessityFromCurrentBlock = Collections.max(distances);
      furthestNecessityFromBlocks.add(furthestNecessityFromCurrentBlock);
    }
    return furthestNecessityFromBlocks.indexOf(Collections.min(furthestNecessityFromBlocks));
  }

  private int furthestDistanceNecessity(int current, String necessity, List<HashMap<String,Boolean>> blocks){


    int pointer = current;
    int distance = blocks.size();
    boolean found = false;

    //check left
    while(pointer >= 0 && !found){
      if(blocks.get(pointer).get(necessity)){
        found = true;
        distance = current - pointer;
      }
      pointer --;
    }

    //check right
    found = false;
    while(pointer < blocks.size() && !found){
      if(blocks.get(pointer).get(necessity)){
        found = true;
        distance = distance > (pointer - current) ? (pointer - current) : distance;
      }
      pointer ++;
    }

    return distance;
  }*/

