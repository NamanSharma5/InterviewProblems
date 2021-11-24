package Facebook;

import java.util.PriorityQueue;

public class MagicalCandyBags {

  static int maxCandies(int[] arr, int k) {
    //fastest way to reorder a list dynamically -- use priorityQueue which in Java is implemented as a binary heap
    // do not think they would ask me to write a binary heap implementation based on arrays in Java

    // problem is that this is ordered based on natural ordering, so would need to write my own comparator to flip the order
    PriorityQueue<Integer> pq = new PriorityQueue<>(arr.length);
    for(int i = 0; i < arr.length; i++){
      pq.add(arr[i]);
    }
    int total= 0;
    for(int i = 0; i < k; i++){
      int max = pq.poll();
      total += max;
      pq.add(max/2);
    }
    return total;
  }


  public static void main(String[] args) {
    int[] arr_2 = {19, 78, 76, 72, 48, 8, 24, 74, 29};
    System.out.println(maxCandies(arr_2,3));

  }

}
