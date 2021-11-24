package Leetcode;

public class FirstBadVersion{


  static public int firstBadVersion(int n) {
    // [1,2,3,4,5 .. n]
//    return helper(1,n);
    System.out.println((int) (1+2)/2);
    return 0;
  }

//  private int helper(int lower, int upper){
//    int mid = (lower+upper) / 2;
//    if(!isBadVersion(mid) && isBadVersion(mid+1)){
//      return mid + 1;
//    }
//    if(isBadVersion(mid)){
//      return helper(lower,mid);
//    }else{
//      return helper(mid,upper);
//    }
//  }

  public static void main(String[] args) {
    firstBadVersion(0);
  }


}
