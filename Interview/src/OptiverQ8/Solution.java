package OptiverQ8;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  // container node for LinkedList of containers
  static class Container{
    Container next = null;
    private int capacity;
    LinkedList<Integer> storedItems = new LinkedList<>();

    public Container(int capacity) {
      this.capacity = capacity;
    }
  }

  // creates LinkedList of Containers based on containers Sizes
  private static Container initialiseContainers(ArrayList<Integer> containerSizes){
    Container first = new Container(containerSizes.get(0));
    Container prev = first;
    Container curr = null;
    if(containerSizes.size() > 1){
      for(int i = 1; i < containerSizes.size(); i++){
        curr = new Container(containerSizes.get(i));
        prev.next = curr;
        prev = curr;
      }
    }
    //Outside Container
    curr = new Container(Integer.MAX_VALUE);
    prev.next = curr;
    return first;
  }

  //Search for item - if it exists remove it & return container number else return -1
  private static int searchContainers(Container first,int toRemove){
    Container curr = first;
    int current = 1;
    while(curr != null){

      if(curr.storedItems.contains(toRemove)){
        if(curr.next != null){
          // have to use removeFirstOccurence otherwise toRemove is considered as index w/ remove func
          curr.storedItems.removeFirstOccurrence(toRemove);
        }
        return current;
      }
      current++;
      curr = curr.next;
    }
    return -1;
  }

  //Add an item to the first container
  private static void addItem(Container first, int toAdd){
    first.storedItems.addFirst(toAdd);
  }


  //Rebalance containers to make sure capacities fit
  private static void rebalance(Container first){
    Container current = first;
    while(current.capacity < current.storedItems.size()){
      int leastRecentlyUsed = current.storedItems.removeLast();
      current.next.storedItems.addFirst(leastRecentlyUsed);
      current = current.next;
    }
  }

  public static void main(String args[]) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */

//    Scanner scanner = new Scanner(System.in);
//    String containerSizesInput = scanner.nextLine();
//    String[] containerSizesString = containerSizesInput.split(" ");
    ArrayList<Integer> containerSizes = new ArrayList<>();
//    for(String s : containerSizesString){
//      containerSizes.add(Integer.parseInt(s));
//    }
//
//    int noOfItems = scanner.nextInt();
    ArrayList<Integer> itemOrder = new ArrayList<Integer>(List.of(1,2,3,4,5,6,7,1));
//    for (int i = 0; i < noOfItems; i++) {
//      itemOrder.add(scanner.nextInt());
//    }

    //FOR TESTING CODE IN CONTAINER SIZES & ITEM ORDER
    containerSizes = new ArrayList<Integer>(List.of(2,2,1));

    System.out.println("Container Sizes: " + containerSizes);
    System.out.println("Order of items worked on: " + itemOrder);

    //Setup Containers as linked list
    Container containers = initialiseContainers(containerSizes);

    // run loop up to penultimate item - since we check position of last item
    // each iteraton remove item if exists, add to beginning, rebalance
    for(int current = 0; current < itemOrder.size() - 1; current++){
      searchContainers(containers,itemOrder.get(current));
      addItem(containers, itemOrder.get(current));
      rebalance(containers);
    }

    int positionOfLast = searchContainers(containers,itemOrder.get(itemOrder.size() - 1));
    if(positionOfLast < 0){
      System.out.println("NEW");
    }else if(positionOfLast > containerSizes.size()){
      System.out.println("OUTSIDE");
    }else{
      System.out.println(positionOfLast);
    }

  }
}