package com.dreamskiale.basic_algorithms.dp;


public class KnapsackWithRepetition implements Knapsack {
  
  private Integer[] maxRevenue;
  private int[] weight;
  private int[] value;

  /**
   * During a robbery, a burglar finds much more loot than he had expected and 
   * has to decide what to take. His bag (or “knapsack”) will hold a total weight 
   * of at most W pounds. There are n items to pick from, of weight w1, . . . , wn and 
   * dollar value v1, . . . , vn. What’s the most valuable combination of items he can 
   * fit into his bag?
   * 
   * https://docs.google.com/spreadsheet/ccc?key=0AuHKpmIAZCN9dDF5RWdlNVd2MDBrR3ZVckVqMklRTmc#gid=0
   * 
   * @param weight
   * @param value
   * @param maxWeight
   * @return
   */
  @Override
  public int maxRevenue(int[] weight, int[] value, int maxWeight) {
    this.weight = weight;
    this.value = value;
    maxRevenue = new Integer[maxWeight+1];
    maxRevenue[0] = 0;

    return maxRevenue0(maxWeight);
  }
  
  private int maxRevenue0(int maxWeight) {
    if (maxWeight < 0) {
      return 0;
    }
    if (maxRevenue[maxWeight] == null) {
      int max = 0;
      for (int i = 0; i < value.length; i++) {
        if (weight[i] <= maxWeight) {
          // One path per any incoming element
          max = Math.max(max, value[i] + maxRevenue0(maxWeight - weight[i]));
        }
      }
      maxRevenue[maxWeight] = max;
    }
    return maxRevenue[maxWeight];
  }
 
}