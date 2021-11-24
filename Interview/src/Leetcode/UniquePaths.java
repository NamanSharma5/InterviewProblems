package Leetcode;

public class UniquePaths {

  // m = rows & n = columns
  public static int uniquePaths(int m, int n) {
    // can only move right or down each step


    /* naive recursive solution
    Using Grid System with each square = (x,y) , where top left = (0,0) & x++ going right & y++ going down
      f(x,y) = f(x+1,y) + f(x,y+1);
     */
    if(m==0 && n==0){
      return 0;
    }
    if(m==0 || n== 0){
      return 1;
    }

    return uniquePathsHelper(new coordinates(0,0),n-1, m-1);
  }

  public static int uniquePathsHelper(coordinates current, int max_x, int max_y){

    // base case
    if(current.distance(new coordinates(max_x,max_y)) == 1){
      return 1;
    }

    // inductive cases

    // on the rightmost squares
    if(current.x == max_x){
      return 1;
    };
    // on the bottommost square
    if(current.y == max_y){
      return 1;
    }

    return uniquePathsHelper(new coordinates(current.x + 1,current.y),max_x,max_y) +
            uniquePathsHelper(new coordinates(current.x,current.y + 1),max_x,max_y);
  }

  public static void main(String[] args) {
    System.out.println(uniquePaths(33,12));
  }

}

//coordinate system
class coordinates {
  int x;
  int y;

  public coordinates(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int distance(coordinates other){
    return Math.abs(x - other.x) + Math.abs(y-other.y);
  }

}
