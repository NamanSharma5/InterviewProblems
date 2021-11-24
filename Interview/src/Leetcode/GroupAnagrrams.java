package Leetcode;

import java.util.List;

public class GroupAnagrrams {

  /* in a given array of strings, group the anagrams together
  ``- not case-sensitive
    - original letters used once only
   */

  /* First Crude/Naive Approach - O(n^3) time complexity to check anagram and check each time in strs and each item in solution set
    - Set up solution list
    - check if head of strings is anagram of any member (head of that member) of solution list
    - if so, add to that member
    - if not, create a new member at the end of the solution list

    requires boolean function to check anagrams
 */

  /* If an optimal solution exists, would have to be in O(n^2) but that means check of which set it belongs in would have to be in O(1)
  since traversing strs has to be in O(n) & checking anagrams within that has to be in O(n)

  // Here is an idea using hashmap & string concatentation
   So traverse test string and create an ID string, which essentially is a string of frequencies i.e: "aab" -> "2,1,0,0,0...." Still O(n) for string equality

  // But an alternative that is O(n^2 log n) with slightly higher memory complexity of O(n) since using Hashmap
    Traverse strs O(n) and for each item sort using merge sort O(n log n) on strings -> check if hashmap contains key:
    - if it does, then add unsorted string to its values list
    - else add key and value to hashmap
    Concat all values in hashmap

    Note: above solution does not explicitly check for anagrams via function but via sorting and comparing


   */

  public List<List<String>> groupAnagrams(String[] strs) {
    return null;
  }

  /* O(n) time complexity & O(1) memory complexity */
  public static boolean checkAnagram(String toCheck, String baseString){
    if(toCheck.length() == baseString.length()){
      String newBaseString = baseString;
      for(int i = 0; i < toCheck.length(); i++){
        newBaseString = newBaseString.replaceFirst(String.valueOf(toCheck.charAt(i)),"");
      }
      if(newBaseString.equals("")){
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String a = new String("a");
    String b = new String("b");
    System.out.println(checkAnagram(a,b));

  }

}
