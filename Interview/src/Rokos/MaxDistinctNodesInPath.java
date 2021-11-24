package Rokos;

import java.util.HashSet;
import java.util.Set;

public class MaxDistinctNodesInPath {
  public int solution(Tree T) {
    HashSet<Integer> test = new HashSet<>();
    return traverse(T,test);
  }

  public static int traverse(Tree root, Set<Integer> mSet) {

    if (root == null || mSet.contains(root.x)) {
      return mSet.size();
    }

    //Add the root to the set
    mSet.add(root.x);
    int l = traverse(root.l, mSet);
    int r = traverse(root.r, mSet);
    //Backtrack and remove the element from the set
    mSet.remove(root.x);

    //return the max path
    return Math.max(l, r);
  }

  public static void main(String[] args) {

  }
}

class Tree {
  public int x;
  public Tree l;
  public Tree r;
}