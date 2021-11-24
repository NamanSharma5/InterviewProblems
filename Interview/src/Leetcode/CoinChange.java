package Leetcode;

import java.util.Arrays;

public class CoinChange {
  /*
  Overview:
  Given an integer array of coins of different denominations & a total amount
  Return the fewest number of coins required to make that amount

  i.e
  Input: coins = [1,2,5], amount = 11    Output: 3
  Input: coins = [2], amount = 3         Output: -1
   */
  public static int coinChange(int[] coins, int amount) {
    /* Some thoughts ->
       iterative approach:
       - principle: min of (coinChange(each value in coins minus amount) + 1)
       i.e for [1,2,5] 11
       min of [coinChange(coins,6),coinChange(coins,9),coinChange(coins,10)] + 1

       Dynamic Programming - solve a problem using solutions to sub problems but storing these solutions rather than recomputing
       But build up by storing array of mins for 0->amount rather than working top down!
     */

    // assumption: array of coins is ordered by denomination size

    return coinChange(coins,amount);
  }

//  public static int coinChangeHelper(int[] coins, int amount){
//
//    if(amount == 0){
//      return 0;
//    }
//
//    if(Arrays.asList(coins).contains(amount)){
//      return 1;
//    }
//
//    for(int i = coins.length - 1; i >=0 ; i--){
//      int quotient = amount / coins[i]; // quotient =2
//      // see how many of the largest denominations I can fit in!
//      for(int j = quotient; i > 0; j--){
//        if(coinChangeHelper(coins, amount - j*coins[i]) > -1){
//          return coinChangeHelper(coins, amount - quotient*coins[i]) + j;
//        }
//      }
//    }
//
//    return 0;
//  }

  public static void main(String[] args) {
    int[] coins = {1,2,5};
    int minCoins = coinChange(coins,11);
    System.out.println(minCoins);
  }

}
