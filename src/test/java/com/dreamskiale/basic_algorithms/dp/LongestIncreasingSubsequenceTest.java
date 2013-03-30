package com.dreamskiale.basic_algorithms.dp;

import org.junit.Assert;
import org.junit.Test;


public class LongestIncreasingSubsequenceTest {
  
  @Test
  public void testSimple() {
    Assert.assertEquals(1, new LongestIncreasingSubsequence().longest("5"));
    Assert.assertEquals(1, new LongestIncreasingSubsequence().longest("52"));
    Assert.assertEquals(1, new LongestIncreasingSubsequence().longest("521"));

    Assert.assertEquals(2, new LongestIncreasingSubsequence().longest("25"));
    Assert.assertEquals(2, new LongestIncreasingSubsequence().longest("253"));

    Assert.assertEquals(3, new LongestIncreasingSubsequence().longest("2534"));

    Assert.assertEquals(4, new LongestIncreasingSubsequence().longest("25346"));
    Assert.assertEquals(4, new LongestIncreasingSubsequence().longest("52863697"));
  }

 
}