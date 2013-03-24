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
  public void testBFS1() {
    Vertex<Integer> head = buildTree1().get(0);
    GraphSearch<Integer> bfs = new BreadthFirstSearch<>();
    
    Iterable<Vertex<Integer>> visited = bfs.search(head);
    
    Integer[] expected = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    
    int i = 0;
    for (Vertex<Integer> v : visited) {
      Assert.assertEquals(expected[i++], v.getValue());
    }
  }

  @Test
  public void testBFS2() {
    Vertex<Integer> head = buildTree2().get(0);
    GraphSearch<Integer> bfs = new BreadthFirstSearch<>();
    
    Iterable<Vertex<Integer>> visited = bfs.search(head);
    
    Integer[] expected = new Integer[] {0, 1, 4, 5, 2, 6, 3};
    
    int i = 0;
    for (Vertex<Integer> v : visited) {
      Assert.assertEquals(expected[i++], v.getValue());
    }
  }

  @Test
  public void testDFS1() {
    Vertex<Integer> head = buildTree1().get(0);
    
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
  public void testDFS2() {
    Vertex<Integer> head = buildTree2().get(0);
    
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
  
  @Test
  public void testHeights() {
    List<Vertex<Integer>> v = buildTree1();
    
    int[] expectedHeights = new int[] {
    // 0  1  2  3  4  5  6  7  8  9  10  11  
       3, 2, 2, 0, 1, 0, 0, 1, 0, 0, 0,  0
    };
    
    for (int i = 0; i < v.size(); i++) {
      Assert.assertEquals(expectedHeights[i], v.get(i).getHeight());
    }
  }
  
  @Test
  public void testDiameterWithHeight_Trees() {
    DiameterStrategy[] strategies = new DiameterStrategy[]{
      new HeightDiameterStrategy()
    };
    
    for (DiameterStrategy s : strategies) {
      Assert.assertEquals(7, buildTree1().get(0).getDiameter(s));
      Assert.assertEquals(9, buildTree3().get(0).getDiameter(s));
      Assert.assertEquals(9, buildTree3().get(1).getDiameter(s));
      Assert.assertEquals(5, buildTree3().get(3).getDiameter(s));
    }
  }
  
  @Test
  public void testDiameterWithHeight_Graphs() {
    DiameterStrategy[] strategies = new DiameterStrategy[]{
      new BFSDiameterStrategy()
    };
    
    for (DiameterStrategy s : strategies) {
      Assert.assertEquals(3, buildGraph0().get(0).getDiameter(s));
      Assert.assertEquals(7, buildGraph1().get(0).getDiameter(s));
      Assert.assertEquals(9, buildGraph3().get(0).getDiameter(s));
      Assert.assertEquals(9, buildGraph3().get(1).getDiameter(s));
      Assert.assertEquals(9, buildGraph3().get(3).getDiameter(s));
    }
  }

  /**
   * Builds this undirected graph:
   * 
   *                0
   *                |
   *        |----------------|
   *        |                |
   *        1                2
   *        
   */
  private List<Vertex<Integer>> buildGraph0() {
    List<Vertex<Integer>> v = new ArrayList<>();
    int n = 3;
    for (int i = 0; i < n; i++) {
      v.add(new Vertex<Integer>(i));
    }

    setAdjacent(v, 0, 1, 2);
    setAdjacent(v, 1, 0);
    setAdjacent(v, 2, 0);

    return v;
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
  private List<Vertex<Integer>> buildTree1() {
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

    return v;
  }

  /**
   * Builds this undirected graph:
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
  private List<Vertex<Integer>> buildGraph1() {
    List<Vertex<Integer>> v = new ArrayList<>();
    int n = 12;
    for (int i = 0; i < n; i++) {
      v.add(new Vertex<Integer>(i));
    }

    setAdjacent(v, 0, 1, 2, 3);
    setAdjacent(v, 1, 0, 4, 5);
    setAdjacent(v, 2, 0, 6, 7);
    setAdjacent(v, 3, 0);
    setAdjacent(v, 4, 1, 8, 9);
    setAdjacent(v, 5, 1);
    setAdjacent(v, 6, 2);
    setAdjacent(v, 7, 2, 10, 11);
    setAdjacent(v, 8, 4);
    setAdjacent(v, 9, 4);
    setAdjacent(v, 10, 7);
    setAdjacent(v, 11, 7);

    return v;
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
  private List<Vertex<Integer>> buildTree2() {
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

    return v;
  }
  
  /**
   * Builds this tree:
   * 
   *                                  0
   *                                  |
   *                  |----------------------------|
   *                  |                            |
   *                  1                            2
   *                  |                            |
   *     |------------------------|                |
   *     |                        |                |
   *     3                        4                5
   *     |                        |        
   * |--------|                   |       
   * |        |                   8       
   * 6        7               |-------|           
   *          |               |       |
   *          |               |       |
   *          9               10      11
   *          |                       |
   *      |-------|                   |
   *      |       |                   |
   *      12      13                  14
   */
  private List<Vertex<Integer>> buildTree3() {
    List<Vertex<Integer>> v = new ArrayList<>();
    int n = 15;
    for (int i = 0; i < n; i++) {
      v.add(new Vertex<Integer>(i));
    }

    setAdjacent(v, 0, 1, 2);
    setAdjacent(v, 1, 3, 4);
    setAdjacent(v, 2, 5);
    setAdjacent(v, 3, 6, 7);
    setAdjacent(v, 4, 8);
    setAdjacent(v, 7, 9);
    setAdjacent(v, 8, 10, 11);
    setAdjacent(v, 9, 12, 13);
    setAdjacent(v, 11, 14);

    return v;
    
  }

  /**
   * Builds this undirected graph:
   * 
   *                                  0
   *                                  |
   *                  |----------------------------|
   *                  |                            |
   *                  1                            2
   *                  |                            |
   *     |------------------------|                |
   *     |                        |                |
   *     3                        4                5
   *     |                        |        
   * |--------|                   |       
   * |        |                   8       
   * 6        7               |-------|           
   *          |               |       |
   *          |               |       |
   *          9               10      11
   *          |                       |
   *      |-------|                   |
   *      |       |                   |
   *      12      13                  14
   */
  private List<Vertex<Integer>> buildGraph3() {
    List<Vertex<Integer>> v = new ArrayList<>();
    int n = 15;
    for (int i = 0; i < n; i++) {
      v.add(new Vertex<Integer>(i));
    }

    setAdjacent(v, 0, 1, 2);
    setAdjacent(v, 1, 0, 3, 4);
    setAdjacent(v, 2, 0, 5);
    setAdjacent(v, 3, 1, 6, 7);
    setAdjacent(v, 4, 1, 8);
    setAdjacent(v, 5, 2);
    setAdjacent(v, 6, 3);
    setAdjacent(v, 7, 3, 9);
    setAdjacent(v, 8, 4, 10, 11);
    setAdjacent(v, 9, 7, 12, 13);
    setAdjacent(v, 10, 8);
    setAdjacent(v, 11, 8, 14);
    setAdjacent(v, 12, 9);
    setAdjacent(v, 13, 9);
    setAdjacent(v, 14, 11);

    return v;
    
  }

  private void setAdjacent(List<Vertex<Integer>> v, int head, int... adjacent) {
    List<Vertex<Integer>> adj;

    adj = v.get(head).getAdjacent();
    for (int i : adjacent) {
      adj.add(v.get(i));
    }
  }

}