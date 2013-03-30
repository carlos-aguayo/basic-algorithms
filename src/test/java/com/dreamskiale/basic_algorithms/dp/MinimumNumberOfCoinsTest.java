package com.dreamskiale.basic_algorithms.dp;

import org.junit.Assert;
import org.junit.Test;


public class MinimumNumberOfCoinsTest {
  
  @Test
  public void testSimple() {
    Assert.assertEquals(3, new MinimumNumberOfCoins().findIterative(63, new int[]{1, 5, 10, 21, 25}));
    Assert.assertEquals(3, new MinimumNumberOfCoins().findRecursive(63, new int[]{1, 5, 10, 21, 25}));
  }
  

}