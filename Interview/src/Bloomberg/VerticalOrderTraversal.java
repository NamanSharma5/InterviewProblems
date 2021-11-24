package Bloomberg;

public class VerticalOrderTraversal {
  /*
  Problem :
   return the nodes of a tree based on the column they fall in
   (x,y) => x = horizontal distance from root i.e for each right branch + 1; for each left branch - 1
         => y = vertical distance from root i.e depth of node

    if multiple nodes in same row and column sort by value
  */

  /*
  Approach:
  1) Build Map from Coordinates to Nodes at that coordinate level
    --  can do this recursively since the coordinates of children can be determined by parent alone
    -- Java is pass by reference and not value so this means can pass around Map as param in
  2) Once map built order by column, then row and then traverse through pulling nodes from map - store values in priorityq so can pull in order
   */

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
