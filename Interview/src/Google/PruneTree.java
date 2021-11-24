package Google;

import java.util.ArrayList;
import java.util.List;

public class PruneTree {

  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> solution = new ArrayList<>();
    int counterForLeafLayers = 0;
    while(root.left != null || root.right != null){
      solution.add(new ArrayList<>());

      findLeavesHelper(root, root.left, counterForLeafLayers, solution);
      findLeavesHelper(root,root.right, counterForLeafLayers, solution);
      counterForLeafLayers++;
    }
//root node
    ArrayList<Integer>arr = new ArrayList<>();
    arr.add(root.val);
    solution.add(arr);

    return solution;
  }


  public void findLeavesHelper(TreeNode parent, TreeNode current, int counter, List<List<Integer>> solution){
    if(current==null){
      return;
    }
    // leaf node
    if(current.left == null && current.right == null){
      solution.get(counter).add(current.val);
      if(parent.left == current){
        parent.left = null;
      }
      if(parent.right == current){
        parent.right = null;
      }
    }

    // Two children or Left Child only or Right Child only
    if(current.left != null){
      findLeavesHelper(current,current.left, counter, solution);
    }
    if(current.right != null){
      findLeavesHelper(current,current.right, counter, solution);
    }
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

