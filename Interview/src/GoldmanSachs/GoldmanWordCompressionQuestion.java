package GoldmanSachs;

import java.util.ArrayList;
import java.util.List;

public class GoldmanWordCompressionQuestion {

  public static String compressWord(String word, int k) {
    // idea:
    // 1) generate list of pairs with <letter,frequency> (same letter can occur twice)
    // 2) function to perform the cut based on value of k - returns boolean - if false, then reconstruct string & return
    // 3) if cut has happened, then merge letters if together & repeat loop from 2

    List<Pair> bindings = generateBinding(word);

    // remove when there is a letter with that frequency & update bindings
    while(removeBinding(bindings,k)){
      String updatedWord = reconstructWord(bindings);
      bindings = generateBinding(updatedWord);
    }

    return reconstructWord(bindings);
  }

  private static class Pair{
    Character letter;
    Integer frequency;

    public Pair(Character letter, Integer frequency) {
      this.letter = letter;
      this.frequency = frequency;
    }

    @Override
    public String toString() {
      return "( " + letter + " , " + frequency + " )";
    }
  }

  private static List<Pair> generateBinding(String word){
    List<Pair> bindings = new ArrayList<Pair>();

    // generate list of pairs
    for(int i = 0; i < word.length(); i++){
      int j = i;
      if(j != word.length() - 1){
        while((j != word.length() - 1) && (word.charAt(j) == word.charAt(j+1))){
          j++;
        }

        bindings.add(new Pair(word.charAt(i),j - i + 1));
      }else{ // last letter in string
        bindings.add(new Pair(word.charAt(i),1));
      }
      i = j;
    }



    for(Pair current: bindings){
      System.out.println(current.toString());
      System.out.println(" ");
    }

    return bindings;
  }

  private static boolean removeBinding(List<Pair> bindings,int k){
    for(Pair current:bindings){
      if(current.frequency == k){
        bindings.remove(current);
        return true;
      }
      if(current.frequency > k){
        current.frequency -= k;
        return true;
      }

    }
    return false;
  }

  private static String reconstructWord(List<Pair> bindings){
    StringBuilder word = new StringBuilder();
    for(Pair current : bindings){
      for(int i = 0; i < current.frequency; i++){
        word.append(current.letter);
      }
    }
    return word.toString();
  }

  public static void main(String[] args) {
    System.out.println(generateBinding("ptmxpmonvnytatktgvibctrhfccccccccccpdbfcluyxrplhegwcbzwpppppppppppppppppppmmmmmmmmmmpmscjaflvwtbnyct"));
  }

}
