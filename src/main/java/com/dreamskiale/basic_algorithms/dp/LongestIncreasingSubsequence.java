package com.dreamskiale.basic_algorithms.dp;

public class LongestIncreasingSubsequence {

  public int longest(String input) {
    int[] longest = new int[input.length()];
    longest[0] = 1;
    return longest(input, input.length() - 1, longest);
  }

  private int longest(String input, int i, int[] longest) {
    if (longest[i] == 0) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        int l = longest(input, j, longest);
        if (input.charAt(j) < input.charAt(i)) {
          max = Math.max(max, l + 1);
        } else {
          max = Math.max(max, l);
        }
      }
      longest[i] = max;
    }
    return longest[i];
  }

}