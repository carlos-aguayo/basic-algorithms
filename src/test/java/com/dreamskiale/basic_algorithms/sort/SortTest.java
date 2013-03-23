package com.dreamskiale.basic_algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {

  @Test
  public void testMergeSort() throws Exception {
    int[] input = new int[]{2,4,76,2,3,8,9,4,3,66,55,44,33};
    int[] expected = new int[]{2,2,3,3,4,4,8,9,33,44,55,66,76};
    
    new MergeSort().sort(input);

    Assert.assertArrayEquals(expected, input);
  }

}