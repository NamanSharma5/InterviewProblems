package Bloomberg;

public class removeDuplicates {

  //Memoisation of consecutive letter count up to certain letter
  public static String removeDuplicatesFunction(String s, int k) {

    // memoised array storing number of consecutive occurences of letter
    int[] consecutiveValueTracker = new int[s.length()];
    StringBuilder solution = new StringBuilder(s);

    // since solution will be getting shorter each removal
    for(int i = 0; i < solution.length(); i ++){
      if(i == 0 || solution.charAt(i) != solution.charAt(i - 1)){
        consecutiveValueTracker[i] = 1;
      }else{
        consecutiveValueTracker[i] = consecutiveValueTracker[i - 1] + 1;
      }
      if(consecutiveValueTracker[i] == k){
        solution.delete(i+1 - k,i+1);
        i = i - k;
      }
    }
    return solution.toString();
  }
  // works but is inefficient O(n^2) in terms of time complexity but memory complexity is O(1)
/*  public static String removeDuplicatesFunction(String s, int k) {
    boolean removed = false;
    String current = s;
    do {
      // keep removing whilst you can
      int left = 0;
      int right = 0;
      int windowSize = 0;
      removed = false;

      // if nothing has been removed & all windows have not been checked continue
      while (!removed && (left <= current.length() - k)) {
        while (current.charAt(left) == current.charAt(right)) {
          right ++;
          windowSize = right - left;
          if (windowSize == k) {
            String leftSide = current.substring(0, left);
            String rightSide = current.substring(right);
            current = leftSide.concat(rightSide);
            System.out.println(current);
            removed = true;
            break;
          }
        }
        left = right;
      }
    } while (removed);

    return current;
  }*/

  public static void main(String[] args) {
    String input = "yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy";
    System.out.println(removeDuplicatesFunction(input,4));

  }
}
