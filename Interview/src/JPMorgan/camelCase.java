package JPMorgan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class camelCase {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    ArrayList<String> input = new ArrayList<>();
    while ((line = in.readLine()) != null) {
      //System.out.println(line);
      input.add(line);
    }
    helperFunction(input);

  }

  public static String helperFunction(ArrayList<String> input){
    StringBuilder output = new StringBuilder();
    int first = 1;
    for(int i = 0; i < input.size(); i++){

      if(input.get(i).equals(" ")){
        output.append(" ");
        first = 1;
      }else{
        String original = input.get(i);
        String newWord = original.substring(0,1).toUpperCase() + original.substring(1).toLowerCase();
        if(first == 1){
          newWord = newWord.toLowerCase();
          first = 0;
        }
        output.append(newWord);
      }
    }

    return output.toString();
  }
}
