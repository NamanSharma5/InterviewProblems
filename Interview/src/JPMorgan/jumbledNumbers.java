package JPMorgan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class jumbledNumbers {

//  public static void main(String[] args) throws IOException {
//    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//    BufferedReader in = new BufferedReader(reader);
//    String line;
//    while ((line = in.readLine()) != null) {
//      System.out.println(line);
//      System.out.println(unJumble(line));
//    }
//  }

  public static String unJumble(String input){
    ArrayList<String> numbers = new ArrayList<>(List.of("zero","one","two","three","four","five","six","seven","eight","nine"));
    ArrayList<Integer> foundNumbers = new ArrayList<>();
    String remainingLetters = input;
    int currentNumber = 0;

    while(remainingLetters.length() > 0 && currentNumber < 10){
      while(checkWord(numbers.get(currentNumber),remainingLetters)){
        foundNumbers.add(currentNumber);
        remainingLetters = removeWord(numbers.get(currentNumber),remainingLetters);
      }
      currentNumber++;
    }

    Collections.sort(foundNumbers);

    return foundNumbers.toString();
  }

  public static boolean checkWord(String toFind, String word){
    for(int i = 0; i < toFind.length(); i++){
      if(word.indexOf(toFind.charAt(i)) == -1){
        return false;
      }
    }
    return true;
  }

  public static String removeWord(String toRemove, String word){
//   StringBuilder newWord = new StringBuilder();
//   for(int i = 0; i < word.length(); i++){
//     if(toRemove.indexOf(word.charAt(i)) == -1){
//       newWord.append(word.charAt(i));
//     }
//   }
   //return newWord.toString();
    String newWord = word;
    for(int i = 0; i < toRemove.length(); i++){
      int position = word.indexOf(toRemove.charAt(i));
      if(position > -1){
        if(position == toRemove.length() - 1){
          newWord = newWord.substring(0,position);
        }else{
          newWord = newWord.substring(0,position)+""+newWord.substring(position+1);
        }
      }
    }
    return newWord;

  }

  public static void main(String[] args) {
    String output = unJumble("reuonnoinfe");
    System.out.println(output);

  }
}
