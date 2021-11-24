package Leetcode;// Given a linked list, swap every two adjacent nodes
// and return its head.
// You must solve the problem without modifying the values in the list's nodes
// (i.e., only nodes themselves may be changed.)

/* examples:
 input: head -> 1,2,3,4
 output head -> 2,1,4,3
 */
public class SwapNodesInPairs {
  public static ListNode swapPairs(ListNode head) {
  // head is itself a number in the list i.e 1 in the list 1,2,3,4
    // store two pointers Left & Right

    ListNode left; // left node to be swapped
    ListNode right; // right node to be swapped
    ListNode prev = null; // when previous node (node left of left before swap)'s next has to be updated after swap

    //empty list
    if(head != null){
      left = head;
    }else{
      return null;
    }
    //singleton list
    if(head.next != null){
      right = head.next;
    }else{
      return head;
    }

    ListNode headSwappedList = right;
    boolean first = true;
    // only terminate
    do{

      //perform swap
      left.next = right.next;
      right.next = left;


      // prev only needs to point to right after swap but not for first list item
      if(!first){
        prev.next= right;
      }

      if(first){
        first= false;
      }
      prev = left;

      // setting up new left & right
      if(left.next != null){
        left = left.next;
      }else{
        return headSwappedList;
      }

      // After shifting to the new left value
      if(left.next != null){
        right = left.next;
      }else{
        return headSwappedList;
      }

    }while(true);
  }

  static String OutputList (ListNode head){
    ListNode current = head;
    if (current == null){
      return "[]";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    while(true){
      sb.append(current.val);
      if(current.next == null){
        break;
      }else{
        sb.append(",");
        current = current.next;
      }
    }
    sb.append("]");
    return sb.toString();
  }

  public static void main(String[] args) {

    ListNode four = new ListNode(4);
    ListNode three = new ListNode(3,four);
    ListNode two = new ListNode(2,three);
    ListNode one = new ListNode(1,two);
    System.out.println(OutputList(one));
    ListNode head = swapPairs(one);
    System.out.println(OutputList(head));

  }
}

// Definition for singly-linked list.
 class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
