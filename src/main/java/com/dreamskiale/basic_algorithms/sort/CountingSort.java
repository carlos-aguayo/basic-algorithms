package com.dreamskiale.basic_algorithms.sort;

public class CountingSort {

  public int[] sort(int[] input, int max) {
    
    // 1. Generate helper array
    int[] count = new int[max+1];
    
    // 2. Count how many elements of each
    for (int i = 0; i < input.length; i++) {
      count[input[i]]++;
    }
    
    // 3. Accumulate
    for (int i = 1; i < count.length; i++) {
      count[i] = count[i] + count[i-1];
    }
    
    // 4. Create output array
    int[] output = new int[input.length];
    for (int i = input.length - 1; i >= 0; i--) {
      output[count[input[i]]-1] = input[i];
      count[input[i]]--;
    }
    
    return output;
  }

}