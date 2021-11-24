package Facebook;

public class noOfVisibleNodes {

  int visibleNodes(Node root) {
    // return depth of tree essentially -- recursive approach
    return treeDepthFinder(root);
  }

  int treeDepthFinder(Node root){
    if (root == null){
      return 0;
    }
    if (root.left == null && root.right == null){
      return 1;
    }
    else{
      return 1 + Integer.max(treeDepthFinder(root.left),treeDepthFinder(root.right));
    }
  }
}

class Node {
  int data;
  Node left;
  Node right;
  Node() {
    this.data = 0;
    this.left = null;
    this.right = null;
  }
  Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}
