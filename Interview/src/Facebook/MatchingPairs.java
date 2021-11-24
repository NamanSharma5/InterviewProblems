package Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MatchingPairs {

  // ONE BIG CONSIDERATION I MISSED IS THAT YOU HAVE TO SWAP SO IF MATCHES == LENGTH AT FIRST, THEN RETURN MATCHES - 2;

  static int matchingPairs(String s, String t) {
    assert (s.length() == t.length());
    // perform 1 swap within s of characters in string to maximise the number of matches between the two strings
    // where a swap is switching two distinct characters in a string
    // & a match is when the characters in the same position are equal in string s & t. i.e s = "abc" t = "abd" -> 2 matches

    /* Naive solution O(n) - looking at all possible swaps and their respective matches, to see which results in max matches
       - This would require 2 functions :
       1) String post swap generator  O(n^2)
       2) match calculator O(n)
    */

    /* Optimisation try to do it O(n) ## note can add only 1 or 2 to current number of matches

    - don't swap any index where there is already a match ! as this will not increase total matches (could decrease by 0/2)
    - go through array & keep track of current matches
    - add every non-match to hashmap, where key - letter from s & values are mappings of letter from s to letter in t
      i.e s = "abcdd" t = "dbcee" a->d  d->e if value matches key then, we can potentially add one swap
          s = "abcde" t = "abced" d->e  e->d if value matches another key & value of other key matches current key then add 2 swaps
      O(n) solution?
     */

    HashMap<Character, ArrayList<Character>> mismatchMapping = new HashMap<>();
    int matches = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == t.charAt(i)) {
        matches++;
      } else {
        if (mismatchMapping.containsKey(s.charAt(i))) {
          ArrayList<Character> values = mismatchMapping.get(s.charAt(i));
          values.add(t.charAt(i));
          mismatchMapping.put(s.charAt(i), values);
        } else {
          ArrayList<Character> values = new ArrayList<>();
          values.add(t.charAt(i));
          mismatchMapping.put(s.charAt(i),values);
        }
      }
    }

    // SINCE SWAP HAS TO OCCUR
    if(matches == s.length()){
      return matches - 2;
    }

    int increaseMatches = 0;
    // if one v has a key in the map & the values of that key contain k, increaseMatches by 2 & break else set increaseMatches to 1
//    mismatchMapping.forEach((k,vs)->{
//      vs.forEach(v->{
//        if (mismatchMapping.containsKey(v)){
//          if(mismatchMapping.get(v).contains(k)){
//            return (matches + 2);
//          }else{
//            increaseMatches = 1;
//          }
//        }
//      });
//    });

    return matches;
  }

  public static void main(String[] args) {
    System.out.println(matchingPairs("abcd","abdc"));
  }
}
