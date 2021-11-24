package Citadel;

import java.util.Arrays;

public class Triplets {
  static int arr[] = new int[]{3,1,2,4};

  static int countTriplets(int listLength, int sum) {
    // Sort input array
    Arrays.sort(arr);

    // Initialize result
    int ans = 0;

    // Every iteration of loop counts triplet with
    // first element as arr[i].
    for (int i = 0; i < listLength - 2; i++) {
      // Initialize other two elements as corner elements
      // of subarray arr[j+1..k]
      int j = i + 1, k = listLength - 1;

      // Use Meet in the Middle concept
      while (j < k) {
        // If sum of current triplet is more or equal,
        // move right corner to look for smaller values
        if (arr[i] + arr[j] + arr[k] > sum)
          k--;

          // Else move left corner
        else {
          // This is important. For current i and j, there
          // can be total k-j third elements.
          ans += (k - j);
          j++;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(countTriplets(arr.length,7));
  }
}
