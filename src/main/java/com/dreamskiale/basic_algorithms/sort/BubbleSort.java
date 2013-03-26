package com.dreamskiale.basic_algorithms.sort;

public class BubbleSort implements Sort {

  /**
   * Start at the beginning of an array and swap the first two elements if 
   * the first is bigger than the second. Go to the next pair, etc, 
   * continuously making sweeps of the array until sorted. O(n^2).
   */
  @Override
  public int[] sort(int[] input) {
    for (int i = 0; i < input.length; i++) {
      for (int j = input.length - 1; j > i; j--) {
        if (input[j] < input[j-1]) {
          swap(input, j, j-1);
        }
      }
    }
    return input;
  }
  
  public static void swap(int[] input, int i, int j) {
    int aux = input[i];
    input[i] = input[j];
    input[j] = aux;
  }

}