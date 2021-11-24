package McKinsey;

public class MaximumIndex {

  // Idea: see if you can don't hit bad index without skipping any steps
  // if you hit, see if you don't hit skipping step 1, then step 2, etc.

  public static int maxIndex(int steps, int badIndex) {

    // start by skipping nothing
    int skip = 0 ;
    int current = 0;
    boolean hitBadIndex = false;

    do{
      current = 0;
      for(int j = 0; j < steps + 1; j++){
        if(j != skip){
          current += j;
        }
        if(current == badIndex){
          skip++;
          hitBadIndex = true;
          break;
        }
      }
      if(hitBadIndex == true){
        hitBadIndex = false;
        continue;
      }
      break;

    }while(true);

    return current;

  }

  public static void main(String[] args) {
    System.out.println(maxIndex(3,3));
  }

}
