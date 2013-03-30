package com.dreamskiale.basic_algorithms.search;

import static com.dreamskiale.basic_algorithms.utils.GraphUtils.buildGraph0;
import static com.dreamskiale.basic_algorithms.utils.GraphUtils.buildGraph1;
import static com.dreamskiale.basic_algorithms.utils.GraphUtils.buildGraph3;
import static com.dreamskiale.basic_algorithms.utils.GraphUtils.buildGraph4;
import static com.dreamskiale.basic_algorithms.utils.GraphUtils.buildTree1;
import static com.dreamskiale.basic_algorithms.utils.GraphUtils.buildTree2;
import static com.dreamskiale.basic_algorithms.utils.GraphUtils.buildTree3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dreamskiale.basic_algorithms.pojos.Vertex;

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
  
  @Test
  public void testTopologicalSort_DFS() {
    DepthFirstSearchRecursive<Integer> dfs = new DepthFirstSearchRecursive<>();
    dfs.dfs(buildGraph4());
    
    Deque<Vertex<Integer>> topologicalSort = dfs.getTopologicalSort();
    
    int[] expected = new int[] {5, 7, 8, 4, 1, 2, 6, 0, 3};
    int i = 0;
    for (Vertex<Integer> v : topologicalSort) {
      Assert.assertEquals(expected[i++], v.getValue().intValue());
    }
  }
  
  @Test
  public void testTopologicalSort_Kahn() {
    KahnTopologicalSort<Integer> kahn = new KahnTopologicalSort<>();
    Deque<Vertex<Integer>> topologicalSort = kahn.getTopologicalSort(buildGraph4());
    
    int[] expected = new int[] {0, 1, 4, 5, 2, 7, 3, 6, 8};
    int i = 0;
    for (Vertex<Integer> v : topologicalSort) {
      Assert.assertEquals(expected[i++], v.getValue().intValue());
    }
    
  }

}