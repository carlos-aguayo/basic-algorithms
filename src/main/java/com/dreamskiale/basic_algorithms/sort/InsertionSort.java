package com.dreamskiale.basic_algorithms.sort;

public class InsertionSort implements Sort {

  @Override
  public int[] sort(int[] input) {
    for (int j = 1; j < input.length; j++) {
      int key = input[j];
      int i = j - 1;
      while (i >= 0 && input[i] > key) {
        input[i+1] = input[i];
        i--;
      }
      input[i+1] = key;
    }
    return input;
  }
 
}