package com.dreamskiale.basic_algorithms.dp;


public class CutRod {
  
  int[] maxRevenues;
  
  /**
   * Find the maximum revenue having a rod of size "size", where prices is the price of the rod per size.
   * 
   * @param size the size of the given rod
   * @param prices
   * @return
   */
  public int findBestRevenueRecursive(int size, int[] prices) {
    maxRevenues = new int[size+1];
    maxRevenues[0] = 0;
    return findBestRevenueRecursive0(size, prices);
  }

  /**
   * For example, the best revenue for a rod of size 4, means that it's the maximum of:
   * 
   * The price of a rod of size 4 plus the best revenue for a rod of size 0.
   * The price of a rod of size 3 plus the best revenue for a rod of size 1.
   * The price of a rod of size 2 plus the best revenue for a rod of size 2.
   * The price of a rod of size 1 plus the best revenue for a rod of size 3.
   * 
   */
  private int findBestRevenueRecursive0(int size, int[] prices) {
    if (maxRevenues[size] == 0) {
      int max = 0;
      for (int i = 1; i <= size; i++) {
        max = Math.max(max, prices[i] + findBestRevenueRecursive0(Math.abs(i-size), prices));
      }
      maxRevenues[size] = max;
    }
    return maxRevenues[size];
  }

  
}