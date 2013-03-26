package com.dreamskiale.basic_algorithms.sort;

import static com.dreamskiale.basic_algorithms.sort.BubbleSort.swap;

public class QuickSort implements Sort {

  /**
   * Pick a random element and partition the array, such that all numbers that are 
   * less than it come before all elements that are greater than it. Then do that for each half, 
   * then each quar- ter, etc. O(n log n) expected, O(n^2) worst case.
   */
  @Override
  public int[] sort(int[] a) {
    quicksort(a, 0, a.length-1);
    return a;
  }
  
  private void quicksort(int[] a, int p, int r) {
    if (p < r) {
      int q = partition(a, p, r);
      quicksort(a, p, q-1);
      quicksort(a, q+1, r);
    }
  }
  
  private int partition(int[] a, int p, int r) {
    int x = a[r];
    int i = p - 1;
    for (int j = p; j < r; j++) {
      if (a[j] < x) {
        i++;
        swap(a, i, j);
      }
    }
    swap(a, i+1, r);
    return i+1;
  }
}