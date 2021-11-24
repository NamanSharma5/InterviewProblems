package Leetcode;

public class ContainerWithMostWater {

  public static int maxArea(int[] height) {


    /* O(n^2) - not the most efficient
    //  require nested loops & variable to keep track of max water
    int maxCapacity = 0;
    int currentCapacity = 0;
    for (int i = 0; i < height.length; i++){
      for(int j = i+1; j < height.length; j++){
        currentCapacity = (j-i)*Math.min(height[i],height[j]);
        if(maxCapacity < currentCapacity){
          maxCapacity = currentCapacity;
        }
      }
    }
    return maxCapacity;*/

    int l = 0;
    int r = height.length - 1;
    int max = (r - l) * Math.min(height[l],height[r]);
    while(l < r){
      if(height[l] < height[r]){
        l++;
      }else{
        r--;
      }
      max = Math.max(max,(r - l) * Math.min(height[l],height[r]));
    }
    return max;
  }

  public static void main(String[] args) {
//    int[] height = {1,8,6,2,5,4,8,3,7};
    // failing test case
    int[] height = {1,2,1};


    System.out.println(maxArea(height));
  }
}
