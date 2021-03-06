package com.dreamskiale.basic_algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {

  @Test
  public void testSort() throws Exception {
    Sort[] sortingAlgorithms = new Sort[]{
      new MergeSort(),
      new QuickSort(),
      new InsertionSort(),
      new BubbleSort()
    };
    
    for (Sort s : sortingAlgorithms) {
      int[] input = new int[]{2,4,76,2,3,8,9,4,3,66,55,44,33};
      int[] expected = new int[]{2,2,3,3,4,4,8,9,33,44,55,66,76};

      int[] output = s.sort(input);
      Assert.assertArrayEquals(expected, output);
    }
  }

  @Test
  public void testCountingSort() throws Exception {
    int[] input = new int[]{2,4,76,2,3,8,9,4,3,66,55,44,33};
    int[] expected = new int[]{2,2,3,3,4,4,8,9,33,44,55,66,76};
    int max = 0;
    for (int i : input) { max = Math.max(max, i); }

    int[] output = new CountingSort().sort(input, max);
    Assert.assertArrayEquals(expected, output);
  }
  
}