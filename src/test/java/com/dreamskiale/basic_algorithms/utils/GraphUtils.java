package com.dreamskiale.basic_algorithms.utils;

import java.util.ArrayList;
import java.util.List;

import com.dreamskiale.basic_algorithms.pojos.UndirectedWeightedGraph;
import com.dreamskiale.basic_algorithms.pojos.Vertex;

public class GraphUtils {

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
  public static List<Vertex<Integer>> buildGraph0() {
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
  public static List<Vertex<Integer>> buildTree1() {
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
  public static List<Vertex<Integer>> buildGraph1() {
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
  public static List<Vertex<Integer>> buildTree2() {
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
  public static List<Vertex<Integer>> buildTree3() {
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
  public static List<Vertex<Integer>> buildGraph3() {
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

  /**
   * Builds this directed graph:
   * 
   *  
   *     1                    0       
   *     |                    |
   *     |                    |
   *     *                    *
   *     2 ------------------*3      4
   *     |
   *     |
   *     *
   *     6 * ------- 5
   *                 |
   *                 |
   *                 *
   *                 7
   *                 |
   *                 |
   *                 *
   *                 8
   */
  public static List<Vertex<Integer>> buildGraph4() {
    List<Vertex<Integer>> v = new ArrayList<>();
    int n = 9;
    for (int i = 0; i < n; i++) {
      v.add(new Vertex<Integer>(i));
    }

    setPointingTo(v, 0, 3);
    setPointingTo(v, 1, 2);
    setPointingTo(v, 2, 3, 6);
    setPointingTo(v, 5, 6, 7);
    setPointingTo(v, 7, 8);

    return v;
  }
  
  /**
   * Builds this DAG:
   * 
   *         A -------6-----* B 
   *       * *                |\
   *      /  |                | 2
   *     1   |                |  \
   *    /    |                |   *
   *  S      4                1    E
   *    \    |                |    *
   *     2   |                |   /
   *      \  |                |  1
   *       * |                * /
   *         C -------3-----* D
   * @return
   */
  public static List<Vertex<String>> buildGraph5() {
    List<Vertex<String>> v = new ArrayList<>();
    v.add(new Vertex<String>("S")); // 0
    v.add(new Vertex<String>("A")); // 1
    v.add(new Vertex<String>("B")); // 2
    v.add(new Vertex<String>("C")); // 3
    v.add(new Vertex<String>("D")); // 4
    v.add(new Vertex<String>("E")); // 5

    setPointingTo(v, 0, 1, 3);
    setPointingTo(v, 1, 2);
    setPointingTo(v, 2, 4, 5);
    setPointingTo(v, 3, 1, 4);
    setPointingTo(v, 4, 5);

    return v;
  }
  
  /**
   * Builds this graph:
   * 
   * A      1       C      3       E
   *
   *     
   * 2              2              1
   *   
   *  
   * B      1       D      4       F
   * 
   * B is connected to C with weight 2
   * D is connected to E with weight 3
   * 
   */
  public static UndirectedWeightedGraph<String> buildGraph6() {
    List<String> nodes = new ArrayList<>();
    nodes.add("A");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");
    nodes.add("E");
    nodes.add("F");
    UndirectedWeightedGraph<String> graph = new UndirectedWeightedGraph<>(nodes);

    graph.setEdge("A", "B", 2);
    graph.setEdge("A", "C", 1);

    graph.setEdge("B", "A", 2);
    graph.setEdge("B", "C", 2);
    graph.setEdge("B", "D", 1);

    graph.setEdge("C", "A", 1);
    graph.setEdge("C", "B", 2);
    graph.setEdge("C", "D", 2);
    graph.setEdge("C", "E", 3);

    graph.setEdge("D", "B", 1);
    graph.setEdge("D", "C", 2);
    graph.setEdge("D", "E", 3);
    graph.setEdge("D", "F", 4);

    graph.setEdge("E", "C", 3);
    graph.setEdge("E", "D", 3);
    graph.setEdge("E", "F", 1);

    graph.setEdge("F", "E", 1);
    graph.setEdge("F", "D", 4);

    return graph;
  }

  /**
   * Builds this graph:
   * 
   * A      6       C      5       E
   *
   *     
   * 5              2              4
   *   
   *  
   * B      2       D      4       F
   * 
   * A is connected to D with weight 4
   * B is connected to C with weight 1
   * C is connected to F with weight 3
   * 
   */
  public static UndirectedWeightedGraph<String> buildGraph7() {
    List<String> nodes = new ArrayList<>();
    nodes.add("A");
    nodes.add("B");
    nodes.add("C");
    nodes.add("D");
    nodes.add("E");
    nodes.add("F");
    UndirectedWeightedGraph<String> graph = new UndirectedWeightedGraph<>(nodes);

    graph.setEdge("A", "B", 5);
    graph.setEdge("A", "C", 6);
    graph.setEdge("A", "D", 4);

    graph.setEdge("B", "A", 5);
    graph.setEdge("B", "C", 1);
    graph.setEdge("B", "D", 2);

    graph.setEdge("C", "A", 6);
    graph.setEdge("C", "B", 1);
    graph.setEdge("C", "D", 2);
    graph.setEdge("C", "E", 5);
    graph.setEdge("C", "F", 3);

    graph.setEdge("D", "A", 4);
    graph.setEdge("D", "B", 2);
    graph.setEdge("D", "C", 2);
    graph.setEdge("D", "F", 4);

    graph.setEdge("E", "C", 5);
    graph.setEdge("E", "F", 4);

    graph.setEdge("F", "C", 3);
    graph.setEdge("F", "D", 4);
    graph.setEdge("F", "E", 4);

    return graph;
  }

  private static <T> void setAdjacent(List<Vertex<T>> v, int head, int... adjacent) {
    List<Vertex<T>> adj = v.get(head).getAdjacent();
    for (int i : adjacent) {
      adj.add(v.get(i));
    }
  }

  private static <T> void setPointingTo(List<Vertex<T>> v, int head, int... adjacent) {
    List<Vertex<T>> adj = v.get(head).getAdjacent();
    for (int i : adjacent) {
      adj.add(v.get(i));
      
      v.get(i).getIncoming().add(v.get(head));
    }
  }
  
  public static <T> Vertex<T> getVertex(List<Vertex<T>> graph, T value) {
    for (Vertex<T> v : graph) {
      if (v.getValue().equals(value)) {
        return v;
      }
    }
    return null;
  }

}