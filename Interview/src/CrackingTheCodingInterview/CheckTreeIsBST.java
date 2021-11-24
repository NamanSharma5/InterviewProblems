package CrackingTheCodingInterview;

public class CheckTreeIsBST {


  public static boolean check (node root){
    // BST have two children
    // BST every node to the left is less than current node

    // DOESN'T WORK recurse with min parameter - if left, then update min to be current value; right doesn't have to be updated to min

    // INORDER TRAVERSAL returns tree in right order iff BST but if duplicates & set invariant - duplicate to left, then if duplicate to right will NOT WORK


    return false;
  }


//
//  public static boolean helper (node current, int min){
//    // not binary tree
//    if(current.children.length > 2){
//      return false;
//    }
//
//    // leaf node
//    if(current.children.length == 0 ){
//      return true;
//    }
//
//    // going left - update min (implicit assumption if left node does not exist then right doesn't
//    if(current.children.length > 0 && current.children[0].value < current.value){
//      // left path works
//      if(helper(current.children[0],current.value)){
//        if(current.children.length > 1 && current.children[1].value > current.value){
//          return helper(current.children[1],min);
//        }else{
//          return false;
//        }
//      }
//    }else{
//      return false;
//    }
//
//
//
//    return true;
//  }

  public static void main(String[] args) {
    node n2 = new node(2);
    node n9 = new node(9);
    node n11 = new node(11);
    node n22 = new node(22);
    node n4 = new node(4,n2,n9);
    node n20 = new node(10,n11,n22);
    node n10 = new node(10,n4,n20);

    boolean solution = check(n10);
    System.out.println(solution);
  }

}

class node{
  int value;
  node[] children;
  // 0 = left & 1 = righy

  node(int value,node left, node right){
    this.value = value;
    this.children = new node[2];
    children[0] = left;
    children[1] = right;
  }

  node(int value){
    this.value = value;
    this.children = new node[0];
  }
}
