package com.dreamskiale.basic_algorithms.dp;

import java.util.Arrays;


public class KnapsackWithoutRepetition implements Knapsack {
  
  private Integer[][] maxRevenue;
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
    maxRevenue = new Integer[maxWeight+1][value.length+1];
    Arrays.fill(maxRevenue[0], 0);

    return maxRevenue0(maxWeight, value.length-1);
  }
  
  /**
   * Say there are four items, the key is to think the DAG in this way:
   * Imagine the following items #{w,v}
   * 1{6,30}, 2{3, 14}, 3{4,16} and 4{2,9}
   * 
   * and a maximum weight of 10.
   * 
   * The last node in the DAG has 2 incoming edges, one where the element #4
   * was used and another one where it wasn't.
   * 
   * https://docs.google.com/drawings/d/1FGUw0bGzLmAgoDxlTcuyJBiShzN8mj8iVDwii_MTPnc/edit
   * 
   */
  private int maxRevenue0(int maxWeight, int n) {
    if (maxWeight < 0 || n < 0) {
      return 0;
    }
    if (maxRevenue[maxWeight][n] == null) {
      int max = 0;
      // Path #1 - Not including the current item
      max = Math.max(max, maxRevenue0(maxWeight, n-1));
      if (weight[n] <= maxWeight) {
        // Path #2 - Including the current item, but only if the weight of the item is less than maxWeight
        max = Math.max(max, value[n] + maxRevenue0(maxWeight - weight[n], n-1));
      }
      maxRevenue[maxWeight][n] = max;
    }
    return maxRevenue[maxWeight][n];
  }
 
}