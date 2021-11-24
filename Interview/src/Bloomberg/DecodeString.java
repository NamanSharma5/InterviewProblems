package Bloomberg;

import java.util.Stack;

public class DecodeString {
  // decode encoded string
  /*
  Examples:
  -- feels like a stack based solution
  - s = "3[a]2[bc]"     --> "aaabcbc"
  - s = "3[a2[c]]"      --> "accaccacc"
  - s = "2[abc]3[cd]ef" --> "abcabccdcdcdef"
   */

  /*
  Overview of solution approach:

  1) Setup solution string & stack
  2) Keep adding characters to stack
  3) When you encounter a closing bracket :
      -


   */

  public static String decodeString(String s) {

    StringBuilder solution = new StringBuilder();
    Stack<Character> stack = new Stack<Character>();

    for(int currentChar = 0; currentChar < s.length(); currentChar++){
      Character currentLetter = s.charAt(currentChar);
      if (currentLetter == ']') {
        StringBuilder wordToBeDuplicated = new StringBuilder();
        while(stack.peek() != '[') {
          wordToBeDuplicated.insert(0, stack.pop());
        }
        String word = wordToBeDuplicated.toString();
        stack.pop();     // top of stack is "["

       // NOT NECESSARILY A 1 DIGIT REPETITION -- need to pop off the stack until peek is no longer a digit & prepend
        int repetitions = Character.getNumericValue(stack.pop());


        for(int i = 0; i < repetitions; i++){
          for(int j = 0; j < word.length();j++){
            stack.push(word.charAt(j));
          }
        }
      }else{
        stack.push(currentLetter);
      }
    }

    while (!stack.isEmpty()){
      solution.insert(0,stack.pop());
    }

    return solution.toString();
  }

  public static void main(String[] args) {
    String input = "3[d]b2[a2[c]]e";
    String decoded = decodeString(input);
    System.out.println(decoded);
  }
}
