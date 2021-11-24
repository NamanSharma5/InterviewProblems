package GoldmanSachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoldmanOfficeDesignQuestion {

  public static int getMaxColors(List<Integer> prices, int money) {
    // to minimise time taken first remove all items in list are larger than money
    prices.stream().filter(item -> item < money);

    // idea - generate all combinations of prices in reverse order of size - filter by sum < money
    // and return as soon as first combination has sum < money, this will prevent having to generate
    // all combinations

    // generate combinations in revers order of size
    for(int i = prices.size(); i > 0; i--){
      // generate specifies the index of item in prices
      List<int[]> combinations = generate(prices.size(),i);

      // go through all combinations and calculate total by looking at index values compared with price list
      for(int[] current : combinations){
        int total = 0;
        for(i = 0; i < current.length; i++){
          total+=prices.get(current[i]);
        }
        if(total <= money){
          return i;
        }
      }
    }
    return 0;

  }

  private static void helper(List<int[]> combinations, int data[], int start, int end, int index) {
    if (index == data.length) {
      int[] combination = data.clone();
      combinations.add(combination);
    } else if (start <= end) {
      data[index] = start;
      helper(combinations, data, start + 1, end, index + 1);
      helper(combinations, data, start + 1, end, index);
    }
  }

  public static List<int[]> generate(int n, int r) {
    List<int[]> combinations = new ArrayList<>();
    helper(combinations, new int[r], 0, n-1, 0);
    return combinations;
  }

  public static void main(String[] args) {
    List<Integer> prices = List.of(5,10,10);
    int money = 5;
    System.out.println(getMaxColors(prices,money));
  }

}
