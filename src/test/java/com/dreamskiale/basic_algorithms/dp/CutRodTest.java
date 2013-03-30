package com.dreamskiale.basic_algorithms.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;


public class CutRodTest {
  
  @Test
  public void testSimple() {
    // This means that for a rod of size 1, we get $1
    // and for a rod of size 2, we get $5
    int[] pricePerRodSize = new int[]   {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
    
    assertEquals(10, new CutRod().findBestRevenueRecursive(4, pricePerRodSize));
  }

  @Test
  public void testMany() {
    // This means that for a rod of size 1, we get $1
    // and for a rod of size 2, we get $5
    int[] pricePerRodSize = new int[]   {0, 1, 5, 8,  9, 10, 17, 17, 20, 24, 30};
    
    // This means that for a rod of size 1, the maximum revenue is $1
    // and for a rod of size 4, the maximum revenue is 10 
    int[] expectedMaxRevenue = new int[]{0, 1, 5, 8, 10, 13, 17, 18, 22, 25, 30};
    
    for(int i = 1; i < expectedMaxRevenue.length; i++) {
      Assert.assertEquals("Failed for rod of size " + i, expectedMaxRevenue[i], new CutRod().findBestRevenueRecursive(i, pricePerRodSize));
    }
  }
  
}