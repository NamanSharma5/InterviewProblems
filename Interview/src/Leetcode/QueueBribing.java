package Leetcode;

import java.util.List;

public class QueueBribing {

  public static int calcBribes(List<Integer> q){
    int counter = 0;
    while(q.get(counter) > q.get(counter + 1)){
      counter++;
    }
    return counter;
  }

  public static void minimumBribes(List<Integer> q) {
    // idea:
    // look through array element by element, front to last
    // as soon as element after > element before, run helper to calculate number of bribes/ too chaotic
    int totalBribes = 0;

    for(int i = 0; i < q.size() - 1; i++){
      if(q.get(i) > q.get(i + 1)){
        int bribes = calcBribes(q.subList(i,q.size()));
        if(bribes > 2){
          System.out.println("Too Chaotic");
          return;
        }
        totalBribes += bribes;
      }
    }
    System.out.println(totalBribes);
  }

  public static void main(String[] args) {
    minimumBribes(List.of(2,1,5,3,4));
  }
}
