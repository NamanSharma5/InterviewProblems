package Leetcode.Strings;

public class LongestPalindromicSubstring {


  public String longestPalindrome(String s) {
    /*
    Approach - start basic:
    O(n^2)
    Two pointers : One at beginning of list moving forward through the list
    Second at the end counting down from the end of the list

    -- Algorithm Step by Step:
    1) Start left pointer from left & right pointer from right end
    2) Count right pointer down & check if equal to left
    - if equal, shift left up & right down & add to StringBuilder
    - else, shift right down & reset left to beginning
    */
    char[] stringArray = s.toCharArray();
    String longest;
    // Abstract away complexity of code into helper functions
    for(int left = 0; left < s.length(); left++){
      for(int right = s.length(); right > left; right--){
        if(checkPalindrome(s.substring(left,right))){
          return s.substring(left,right);
        }
      }
    }

    // Dynamic Programming to check current string by looking at smaller string and checking its outer left/right
    // going through string and running expansion at new index

    return null;
  }

  private boolean checkPalindrome(String substring) {
    return false;
  }
}
