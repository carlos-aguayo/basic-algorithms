package com.dreamskiale.basic_algorithms.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;


public class KnapsackTest {
  
  @Test
  public void testSimple() {
    int[] weights = new int[]{6, 3, 4, 2};
    int[] values = new int[]{30, 14, 16, 9};
    
    int[] maxWeight  = new int[]{2,  3,  4,  5,  6, 10};
    int[] maxRevenue = new int[]{9, 14, 18, 23, 30, 48};
    
    for (int i = 0; i < maxWeight.length; i++) {
      assertEquals("Failed at " + i, maxRevenue[i], new Knapsack().findMaxRevenue(weights, values, maxWeight[i]));
    }
        
  }

  
}