package com.dreamskiale.basic_algorithms.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;


public class MinimumNumberOfCoinsTest {
  
  @Test
  public void testSimple() {
    Assert.assertEquals(3, new MinimumNumberOfCoins().findBottomUp(63, new int[]{1, 5, 10, 21, 25}));
    Assert.assertEquals(3, new MinimumNumberOfCoins().findTopDown(63, new int[]{1, 5, 10, 21, 25}));
  }
  
  @Test
  public void testSimple2() {
    int[] coinValues = new int[]{1, 3, 5};
    int[] expectedMinNumberOfCoins = new int[]{0, 1, 2, 1, 2, 1, 2, 3, 2, 3, 2, 3};
    
    for (int i = 1; i < expectedMinNumberOfCoins.length; i++) {
      assertEquals("Failed for " + i, expectedMinNumberOfCoins[i], new MinimumNumberOfCoins().findBottomUp(i, coinValues));
      assertEquals("Failed for " + i, expectedMinNumberOfCoins[i], new MinimumNumberOfCoins().findTopDown(i, coinValues));
    }
  }

}