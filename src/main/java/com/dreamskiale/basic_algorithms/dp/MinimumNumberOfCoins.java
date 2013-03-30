package com.dreamskiale.basic_algorithms.dp;


public class MinimumNumberOfCoins {
  
  private Integer[] minNumberOfCoins;
  
  public int findRecursive(int sum, int[] coinValues) {
    minNumberOfCoins = new Integer[sum+1];
    minNumberOfCoins[0] = 0;
    return findRecursive0(sum, coinValues);
  }
  
  /**
   * Imagine coins with value:
   * 1c, 5c, 10c, 21c and 25 cents.
   * 
   * What's the minimum number of coins needed to have 63 cents?
   * 
   * The solution should be the minimum of:
   * One 1c coin, plus the best solution for 62 cents
   * One 5c coin, plus the best solution for 58 cents
   * One 10c coin, plus the best solution for 53 cents
   * One 21c coin, plus the best solution for 42 cents
   * One 25c coin, plus the best solution for 38 cents
   * 
   */
  private Integer findRecursive0(int sum, int[] coinValues) {
    if (sum < 0) { return null; }
    if (minNumberOfCoins[sum] == null) {
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < coinValues.length; i++) {
        Integer remainder = findRecursive0(sum-coinValues[i], coinValues);
        if (remainder != null) {
          min = Math.min(min, 1 + remainder);
        }
      }
      minNumberOfCoins[sum] = min;
    }
    return minNumberOfCoins[sum];
  }
  
  public int findIterative(int sum, int[] coinValues) {
    int[] min = new int[sum+1];
    min[0] = 0;
    for (int i = 1; i < min.length; i++) {
      min[i] = Integer.MAX_VALUE;
    }
    
    for (int i = 1; i <= sum; i++) {
      for (int j = 0; j < coinValues.length; j++) {
        int vj = coinValues[j];
        if (i - vj < 0) { continue; }
        int a = min[i-vj] + 1;
        int b = min[i];
        if (a < b) {
          min[i] = a;
        }
      }
    }
    
    return min[sum];
  }
  
}