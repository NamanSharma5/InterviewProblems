package Google;

public class CutsStringIntoPalindromes {
  /*
    Overview:
    Find minimum number of cuts required to cut String s into substrings, which are all palindromes
    i.e "google" -> "goog" | "l" | "e"  (2 cuts)


    Initial idea:
    keep extending until current frame is no longer a palindrome and then cut X
    - doesn't work; example: "cheese" -> 3: "c" | "h" | "e" | "ese" NOT 4: "c" | "h" | "ee" | "s" | "e"

    do you want to find longest sub palindrome and then make cuts around it & recurse left / right?
    - Maybe but depends: example: "shshsssh" -> 3: "shshs" | "ss" | "h" OR 2: "shs" | "hsssh"

    It is better to have longer pallindromic strings so could use some scoring function:
      Score = Sigma ( palindrome length ^ 2)

    Recursive Solution Outline - Max total number of characters involved in a palindrome of over length 1!
    1) Starting from length of string - check if palindromes exist
       if do: recursively check remainder of string using helper & sum up
       if not: check for palindrome 1 character shorter & so on

    */
  
  public static int cutStringIntoPalindromes(String s){

    // Attempting recursive solution
    return cutStringIntoPalindromesHelper(s,s.length());

  }

  public static int cutStringIntoPalindromesHelper(String s, int longestPalindrome){
    // base cases:
    if(longestPalindrome == 1){
      return s.length() - 1;
    }
    if(s.length() == 1){
      return 1;
    }
    if(s.length() == 0){
      return 0;
    }

    if(longestPalindrome > s.length()){
      return cutStringIntoPalindromesHelper(s,s.length());
    }

    // recursive cases:
    int minCuts = Integer.MAX_VALUE;

    for(int i = 0; i + longestPalindrome <= s.length(); i++){
      if(checkPalindrome(s.substring(i,i+longestPalindrome))){
        int toAdd = 2;
        if(i == 0 || i == (s.length() - 1 - longestPalindrome)){
          toAdd = 1;
        }

        String leftString = s.substring(0,i);
        String rightString = s.substring(i+longestPalindrome);

        int leftOfFoundPalindrome = cutStringIntoPalindromesHelper(leftString,longestPalindrome - 1);
        int rightOfFoundPalindrome =  cutStringIntoPalindromesHelper(rightString,longestPalindrome - 1);
        int totalCuts = toAdd + leftOfFoundPalindrome + rightOfFoundPalindrome;

        minCuts = Math.min(totalCuts, minCuts);
      }else{
        minCuts= cutStringIntoPalindromesHelper(s,longestPalindrome - 1);
      }
    }
    return minCuts;
  }

  public static boolean checkPalindrome(String s){
    int left = 0;
    int right = s.length() - 1;
    while(left < right){
      if(s.charAt(left) != s.charAt(right)){
        return false;
      }
      left ++;
      right --;
    }
    return true;
  }

  public static void main(String[] args) {
    String s4 = "google";
    System.out.println(cutStringIntoPalindromes(s4));

  }

//  Dynamic Programming Outline -
//  Consider a string s: add character to end - if whole word is now palindrome then return 0;
//  String s = "r" ++ "a" ++ "a"

}
