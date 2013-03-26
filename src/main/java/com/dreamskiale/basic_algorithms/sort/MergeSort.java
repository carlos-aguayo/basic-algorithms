package com.dreamskiale.basic_algorithms.sort;

public class MergeSort implements Sort {

  /**
   * Sort each pair of elements. Then, sort every four elements by merging every two pairs.
   * Then, sort every 8 elements, etc. O(n log n) expected and worst case.
   */
  @Override
  public int[] sort(int[] a) {
    mergesort(a, 0, a.length-1);
    return a;
  }
  
  private void mergesort(int[] a, int p, int r) {
    if (p < r) {
      int q = (p + r) / 2;
      mergesort(a, p, q);
      mergesort(a, q + 1, r);
      merge(a, p, q, r);
    }
  }
  
  private void merge(int[] a, int p, int q, int r) {
    int n1 = q - p + 1;
    int n2 = r - q;
    
    int[] left = new int[n1+1];
    int[] right = new int[n2+1];
    
    for (int i = 0; i < n1; i++) {
      left[i] = a[i + p];
    }
    for (int j = 0; j < n2; j++) {
      right[j] = a[j + q + 1];
    }
    
    left[n1] = Integer.MAX_VALUE;
    right[n2] = Integer.MAX_VALUE;
    
    for (int k = p, i = 0, j = 0; k <= r; k++) {
      if (left[i] <= right[j]) {
        a[k] = left[i];
        i++;
      } else {
        a[k] = right[j];
        j++;
      }
    }
  }

}