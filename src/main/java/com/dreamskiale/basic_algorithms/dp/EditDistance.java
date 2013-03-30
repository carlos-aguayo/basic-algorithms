package com.dreamskiale.basic_algorithms.dp;

public class EditDistance {

  private String start;
  private String end;
  private Integer[][] e;

  /**
   * http://www.cs.berkeley.edu/~vazirani/algorithms.html
   * Page 176
   * 
   * https://docs.google.com/spreadsheet/ccc?key=0AuHKpmIAZCN9dFRMMElCZ2V6eGp4cjRGeTNfYkRBLVE#gid=0
   * 
   * 
   */
  public int find(String start, String end) {
    this.start = start;
    this.end = end;
    
    int m = end.length();
    int n = start.length();
    
    e = new Integer[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      e[i][0] = i;
    }
    for (int i = 0; i <= n; i++) {
      e[0][i] = i;
    }
    return find(m, n);
  }

  private int find(int m, int n) {
    if (m < 0 || n < 0) {
      return Integer.MAX_VALUE - 1;
    }
    if (e[m][n] == null) {
      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          int distance = Integer.MAX_VALUE;

          int a = find(i - 1, j) + 1;
          int b = find(i, j - 1) + 1;
          int c = find(i - 1, j - 1) + diff(i, j);

          distance = Math.min(distance, a);
          distance = Math.min(distance, b);
          distance = Math.min(distance, c);
          e[i][j] = distance;
        }
      }
    }
    return e[m][n];
  }

  private int diff(int m, int n) {
    return (start.charAt(n-1) == end.charAt(m-1)) ? 0 : 1;
  }

}