package LinkedLists;

import javax.crypto.spec.ChaCha20ParameterSpec;

public class AddTwoNumbers {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // idea:
    // use a stringbuilder to build the two numbers
    // convert to int, sum, convert to string
    // build list for number

    StringBuilder num1 = new StringBuilder();
    StringBuilder num2 = new StringBuilder();

    // lists are non-empty
    ListNode curr = l1;
    while(curr != null){
      num1.append(curr.val);
      curr = curr.next;
    }
    num1.reverse();

    curr = l2;
    while(curr != null){
      num2.append(curr.val);
      curr = curr.next;
    }
    num2.reverse();

    String sum = Integer.toString(Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString()));

    // reverse sum
    StringBuilder reversed = new StringBuilder();
    reversed.append(sum).reverse();
    sum = reversed.toString();


    return buildList(sum);
  }

  public static ListNode buildList(String input){
    ListNode previous;
    ListNode current;
    ListNode head = new ListNode(Character.getNumericValue(input.charAt(0)));
    previous = head;

    for(int i = 1; i < input.length(); i++){
      current = new ListNode(Character.getNumericValue(input.charAt(i)));
      previous.next = current;
      previous = current;
    }
    return head;
  }

  public static void main(String[] args) {
    String input1 = "1999999999";
    String input2 = "9";
    ListNode node1 = buildList(input1);
    ListNode node2 = buildList(input2);
    ListNode result = addTwoNumbers(node1,node2);
    System.out.println("complete");
  }
}


class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
