package com.dreamskiale.basic_algorithms.dp;


public class Knapsack {
  
  private Integer[] maxRevenue;
  private int[] weight;
  private int[] value;

  public int findMaxRevenue(int[] weight, int[] value, int maxWeight) {
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
        int v = weight[i] <= maxWeight ? value[i] : 0;
        max = Math.max(max, v + maxRevenue0(maxWeight - weight[i]));
      }
      maxRevenue[maxWeight] = max;
    }
    return maxRevenue[maxWeight];
  }
 
}