package Leetcode.Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class CircularArraySearch {
  public static int minSteps(String[] tools,int startingIndex, String targetTool){
    ArrayList<Integer> occurences = new ArrayList<>();

    for(int i = 0; i < tools.length; i++){
      if(tools[i].equals(targetTool)){
        int distance = Math.min(Math.abs(startingIndex - i),(tools.length - startingIndex + i));
        occurences.add(distance);
      }
    }
    return Collections.min(occurences);
  }

  public static void main(String[] args) {
    String[] tools = {"saw","hammer","mallet","file","saw","ladder","scissor"};
    int min = minSteps(tools,6,"saw");
    System.out.println(min);
  }
}
