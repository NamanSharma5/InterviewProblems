package Leetcode;

import java.util.ArrayList;

public class KthSmallestElementInBST {
  /*
    Overview:
    Return Kth smallest element in BST, with 1- indexing (i.e indexing starts from 1)

    Solution Idea:
    Count how many nodes are on the left or right if k < left ; then search left else search right recursively but subtract k from no of nodes etc

    NO!

    Keep it simple - DFS with inorder traversal returns nodes in a BST in an ordered fashion!
   */

  public static void inOrderTraversal(TreeNode current,ArrayList<Integer> values){
    if(current == null){
      return;
    }
    inOrderTraversal(current.left,values);
    values.add(current.val);
    inOrderTraversal(current.right,values);
  }

  public int kthSmallest(TreeNode root, int k) {
    ArrayList<Integer> nodeVals = new ArrayList<>();
    inOrderTraversal(root,nodeVals);
    return nodeVals.get(k-1);
  }

  // Stupidly over-complicated the solution; just use DFS to get ordered list of node values and return value from this list

  public int kthSmallestHelper(TreeNode current, int k){

    if (k == 1){
      return current.left == null ? current.val : current.left.val;
    }
    // check if number of items on the left of the tree > k - if so then solution lies in left sub tree
    int leftChildTreeSize = sizeOfTree(current.left);
    if (k <= leftChildTreeSize) {
      return kthSmallestHelper(current.left,k);
    }

    // i.e: if current item/ root of current subtree is the one we want
    if(leftChildTreeSize + 1 == k){
      return current.val;
    }

    return kthSmallestHelper(current.right, k - leftChildTreeSize - 1); // -1 for the current root

  }

  public static int sizeOfTree(TreeNode current){

    if(current == null){
      return 0;
    }

    if(current.left == null && current.right == null) {
      return 1;
    }

    return sizeOfTree(current.left) + sizeOfTree(current.right) + 1;
  }

  public static void main(String[] args) {

  }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
       this.right = right;
    }
}
