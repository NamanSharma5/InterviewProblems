package Leetcode.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestSubstringNoRepeatingCharacters {

  public static int lengthOfLongestSubstring(String s) {

    HashMap<Character,Integer> seen = new HashMap<>();
    int max = 0;
    int current = 0;
    for(int i = 0; i < s.length(); i++){
      if(seen.containsKey(s.charAt(i))){
        current = 0;
        i = seen.get(s.charAt(i));
        seen.clear();
      }else {
        current++;
        seen.put(s.charAt(i), i);
        if (max < current) {
          max = current;
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {

    System.out.println("dvdf " + (lengthOfLongestSubstring("dvdf") == 3));
    System.out.println("d" + (lengthOfLongestSubstring("d") == 1));
    System.out.println(" " + (lengthOfLongestSubstring(" ") == 1));
    System.out.println("abcddcba " + (lengthOfLongestSubstring("abcddcba") == 4));
    System.out.println("abcddcbae " + (lengthOfLongestSubstring("abcddcbae") == 5));
    System.out.println("abcabcbb " + (lengthOfLongestSubstring("abcabcbb") == 3));

  }

}
