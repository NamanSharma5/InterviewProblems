package Google;

import java.util.*;

public class MinNumberOfChairs {


  public static int minChairs(int[] S, int[] E) {
    ArrayList<pair> pairs = new ArrayList<>();

    for(int i = 0; i < E.length; i++) { // O(n)
      pairs.add(new pair(S[i],1));
      pairs.add(new pair(E[i],-1));
    }

    mergeSort(pairs);

    return  0;
  }

  public static List mergeSort(List input) {
    if(input.size() == 1) return input;

    List firstHalf = input.subList(0,input.size() / 2);
    List secondHalf = input.subList(input.size()/2,input.size());
    List output = merge(mergeSort(firstHalf),mergeSort(secondHalf));

    return output;
  }

  public static List merge(List input1, List input2) {

    return null;
  }

  public static void main (String[]args){
    int[] s = {1, 2, 6, 5, 3};
    int[] e = {5, 5, 7, 6, 8};
    System.out.println(minChairs(s, e));
  }
}

class pair implements Comparator{

  int first;
  int last;

  public pair(int first,int last) {
    this.first = first;
    this.last = last;
  }

  @Override
  public int compare(Object a1, Object b1) {
    pair a = (pair) a1;
    pair b = (pair) b1;
    if(a.first < b.first) return -1;
    if(a.first == b.first && a.last < b.last) return -1;
    if(a.first == b.first && a.last == b.last) return 0;
    return 1;
  }
}

  // O(m * n) can be quite slow if a few random people stay till late
/*
  public static int minChairs(int[] S, int[] E){

    int maxDuration = Arrays.stream(E).max().getAsInt(); // O(n)

    //setup Hashmap
    HashMap<Integer,ArrayList<Integer>> peopleAtTime = new HashMap<>();
    for(int i = 1; i < maxDuration+ 1; i++){ // O(m) where m = time of person who stays latest
      peopleAtTime.put(i,new ArrayList<>());
    }

    // naive solution using hashmap complexity = O(m * n) where m = time of person who stays latest
    for(int i = 0; i < S.length; i++){
      int arrivalTime = S[i];
      int departureTime = E[i];
      for(int j = arrivalTime; j < departureTime; j++){
        ArrayList<Integer> peoplePresent = peopleAtTime.get(j);
        peoplePresent.add(i);
        peopleAtTime.put(j,peoplePresent);
      }
    }

    int minChairs = 0;
    for(ArrayList current : peopleAtTime.values()){ // O(m)
      minChairs = Math.max(minChairs,current.size());
    }

    return minChairs;
  }
 }
*/



