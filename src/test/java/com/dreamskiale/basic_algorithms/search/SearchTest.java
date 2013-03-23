package com.dreamskiale.basic_algorithms.search;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dreamskiale.basic_algorithms.pojos.Vertex;
import com.dreamskiale.basic_algorithms.search.BreadthFirstSearch;
import com.dreamskiale.basic_algorithms.search.DepthFirstSearchIterative;
import com.dreamskiale.basic_algorithms.search.DepthFirstSearchRecursive;
import com.dreamskiale.basic_algorithms.search.GraphSearch;

public class SearchTest {

  @Test
  public void testBFS1() throws Exception {
    Vertex<Integer> head = buildGraph1();
    GraphSearch<Integer> bfs = new BreadthFirstSearch<>();
    
    Iterable<Vertex<Integer>> visited = bfs.search(head);
    
    Integer[] expected = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    
    int i = 0;
    for (Vertex<Integer> v : visited) {
      Assert.assertEquals(expected[i++], v.getValue());
    }
  }

  @Test
  public void testBFS2() throws Exception {
    Vertex<Integer> head = buildGraph2();
    GraphSearch<Integer> bfs = new BreadthFirstSearch<>();
    
    Iterable<Vertex<Integer>> visited = bfs.search(head);
    
    Integer[] expected = new Integer[] {0, 1, 4, 5, 2, 6, 3};
    
    int i = 0;
    for (Vertex<Integer> v : visited) {
      Assert.assertEquals(expected[i++], v.getValue());
    }
  }

  @Test
  public void testDFS1() throws Exception {
    Vertex<Integer> head = buildGraph1();
    
    List<GraphSearch<Integer>> l = new ArrayList<>();
    l.add(new DepthFirstSearchRecursive<Integer>());
    l.add(new DepthFirstSearchIterative<Integer>());
    
    for (GraphSearch<Integer> bfs : l) {
      Iterable<Vertex<Integer>> visited = bfs.search(head);
      
      Integer[] expected = new Integer[] {0, 1, 4, 8, 9, 5, 2, 6, 7, 10, 11, 3};
      
      int i = 0;
      for (Vertex<Integer> v : visited) {
        Assert.assertEquals(expected[i++], v.getValue());
      }
    }
  }

  @Test
  public void testDFS2() throws Exception {
    Vertex<Integer> head = buildGraph2();
    
    List<GraphSearch<Integer>> l = new ArrayList<>();
    l.add(new DepthFirstSearchRecursive<Integer>());
    l.add(new DepthFirstSearchIterative<Integer>());

    for (GraphSearch<Integer> bfs : l) {
      Iterable<Vertex<Integer>> visited = bfs.search(head);

      Integer[] expected = new Integer[] {0, 1, 2, 3, 4, 5, 6};

      int i = 0;
      for (Vertex<Integer> v : visited) {
        Assert.assertEquals(expected[i++], v.getValue());
      }
    }
  }

  /**
   * Builds this tree:
   * 
   *                         0
   *                         |
   *        |----------------|-------------|
   *        |                |             |
   *        1                2             3
   *        |                |
   *    |-------|       |---------|
   *    |       |       |         |
   *    4       5       6         7
   *    |                         |
   * |-----|                  |-------|
   * |     |                  |       |
   * 8     9                  10      11
   */
  private Vertex<Integer> buildGraph1() {
    List<Vertex<Integer>> v = new ArrayList<>();
    int n = 12;
    for (int i = 0; i < n; i++) {
      v.add(new Vertex<Integer>(i));
    }

    setAdjacent(v, 0, 1, 2, 3);
    setAdjacent(v, 1, 4, 5);
    setAdjacent(v, 2, 6, 7);
    setAdjacent(v, 4, 8, 9);
    setAdjacent(v, 7, 10, 11);

    return v.get(0);
  }

  /**
   * Builds this tree:
   *
   *  0 --- 1 --- 2
   *  |\    |     |
   *  | \   |     |
   *  |  \  6 --  |
   *  |   \ |   \ |
   *  |    \|    \|
   *  5 ----4 ----3
   *  
   */
  private Vertex<Integer> buildGraph2() {
    List<Vertex<Integer>> v = new ArrayList<>();
    int n = 7;
    for (int i = 0; i < n; i++) {
      v.add(new Vertex<Integer>(i));
    }

    setAdjacent(v, 0, 1, 4, 5);
    setAdjacent(v, 1, 0, 2, 6);
    setAdjacent(v, 2, 1, 3);
    setAdjacent(v, 3, 2, 4, 6);
    setAdjacent(v, 4, 3, 5, 6);
    setAdjacent(v, 5, 0, 4);
    setAdjacent(v, 6, 1, 3, 4);

    return v.get(0);
  }

  private void setAdjacent(List<Vertex<Integer>> v, int head, int... adjacent) {
    List<Vertex<Integer>> adj;

    adj = v.get(head).getAdjacent();
    for (int i : adjacent) {
      adj.add(v.get(i));
    }
  }

}