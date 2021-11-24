package Facebook;

public class ElementSwapping {

  int[] findMinArray(int[] arr, int k) {
    /* Overview:
    - perform k swaps of consecutive elements to get the lexicographically smallest list
    - Lexicographically smaller : first index where x & y diverge, x's element at that index < y's element at that index

    - Want to order list as much as possible from beginning - i.e: start with smallest and then build up!
    so start by moving smallest item to beginning & repeat for remainder of list
    but if cannot move smallest item to front in k moves, then find smallest item you can move in k moves


   OR! what is the smallest item in the first k elements, move this TO front,
   then find smallest item if k > lenght of list & repeat!
     */

    /* Pseudocode:

   1) if (k < arr.length) -> swap smallest item in first k items to front
      else -> move smallest item in list to front & set k = k - arr.length

      Repeat (1)

     */

    
    return null;
  }
}
