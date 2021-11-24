package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.List;

public class p70_findSubstringPermsInString {
  public static List<Integer> solution(String sub, String b){

    int subLength = sub.length();
    List<Integer> solution = new ArrayList<>();

    for(int i = 0; i < b.length() - subLength; i++){
      if(checkPerm(b.substring(i,i+subLength),sub)){
        solution.add(i);
      }
    }
    return solution;
  }

  public static boolean checkPerm(String s, String sub){
    String test = String.copyValueOf(sub.toCharArray());
    for(int i = 0; i < s.length();i++){
      if(!test.contains(String.valueOf(s.charAt(i)))){
        return false;
      }
      // REPLACE FIRST IS NOT REMOVING THE LETTER FOR SOME REASON
//      test.replaceFirst(String.valueOf(s.charAt(i)),"");
      test.replaceFirst(String.valueOf(s.charAt(i)),".");
    }
    return true;
  }

  public static void main(String[] args) {
    String sub = "hip";
    String b = "chipphi";
    System.out.println(solution(sub,b));
  }
}
