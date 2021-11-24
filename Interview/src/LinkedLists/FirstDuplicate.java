package LinkedLists;

import java.util.ArrayList;

public class FirstDuplicate {

  // using a list
  int firstDuplicate(node head){
    Integer firstValue = Integer.MAX_VALUE;
    ArrayList<Integer> seen = new ArrayList<>();

    node curr = head;
    while(curr.next != null){
      if(!seen.contains(curr.value)){
        seen.add(curr.value);
      }else{ // duplicate node found
        if(firstValue > curr.value){
          firstValue = curr.value;
        }
      }
      curr = curr.next;
    }

    return firstValue;
  }

  public static void main(String[] args) {

  }
}


class node{
  int value;
  node next;

  public node (int value){
    this.value = value;
    this.next = null;
  }

  public node(int value, node next) {
    this.value = value;
    this.next = next;
  }
}


