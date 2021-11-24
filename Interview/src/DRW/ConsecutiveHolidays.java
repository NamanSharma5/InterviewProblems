package DRW;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ConsecutiveHolidays {
  /*
  Overview:
   - Convert Array to set to find no of unique locations!
   - then use sliding window approach to do it - O(n) time complexity
   */
  public static int solution(int[] A) {
    Set<Integer> uniqueLocations = new HashSet<>();
    for(int i = 0; i < A.length; i++){
      uniqueLocations.add(A[i]);
    }
    int noOfUniqueLocations = uniqueLocations.size();

    return minRange(A,A.length,noOfUniqueLocations);
  }

  // minimum range with k distinct elements
  private static int minRange(int arr[], int n, int k)
  {
     /* To start left and right side are both -1,
     number of distinct elements are zero and
     range is n.*/
    int left = 0;
    int right = n;

    // Initialize right side
    int j = -1;

    HashMap<Integer, Integer> map = new HashMap<>(); // to store distinct elements

    for(int i = 0; i < n; i++) {
      while (j < n) {
        j++;// increase right side.
        // If number of distinct elements less than k
        if (j < n && map.size() < k) {
          map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
        }
        // If length is less than previous length - smaller range
        if (map.size() == k && ((right - left) >= (j - i))) {
          left = i;
          right = j;
          break;
        }
      }
      // If number of distinct elements less than k -> break
      if (map.size() < k){
        break;
      }
      // If distinct elements equals to k then try to increase left side.
      while (map.size() == k) {
        if (map.getOrDefault(arr[i], 0) == 1) {
          map.remove(arr[i]);
        }else {
          map.put(arr[i], map.getOrDefault(arr[i], 0) - 1);
        }
        // Increment left side.
        i++;
        if (map.size() == k && (right - left) >= (j - i)) {
          left = i;
          right = j;
        }
      }
      if (map.getOrDefault(arr[i], 0) == 1){
        map.remove(arr[i]);
      } else{
        map.put(arr[i], map.getOrDefault(arr[i], 0) - 1);
      }
    }
    return right - left + 1; // since array indexing is inclusive
  }

  public static void main(String[] args) {
    int[] test = {1,2,4,4,5};
    solution(test);
    System.out.println("done");
  }
}
