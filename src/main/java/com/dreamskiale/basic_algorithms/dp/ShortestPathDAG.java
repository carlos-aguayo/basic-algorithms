package com.dreamskiale.basic_algorithms.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dreamskiale.basic_algorithms.pojos.Vertex;

public class ShortestPathDAG<T> {

  private Map<Vertex<T>, Integer> distanceTo = new HashMap<>();
  
  /**
   * Returns the shortest distance from start to finish in the directed graph.
   */
  public int search(List<Vertex<T>> dag, Vertex<T> start, Vertex<T> finish) {
    distanceTo.clear();
    distanceTo.put(start, 0);
    
    int minDistance = search0(dag, finish);
    
    return minDistance;
  }

  private int search0(List<Vertex<T>> dag, Vertex<T> vertex) {
    if (!distanceTo.containsKey(vertex)) {
      int minDistanceToVertex = Integer.MAX_VALUE;
      // The shortest path will be the distance to one of the parents plus one.
      for (Vertex<T> parent : vertex.getIncoming()) {
        minDistanceToVertex = Math.min(minDistanceToVertex, search0(dag, parent) + 1);
      }
      distanceTo.put(vertex, minDistanceToVertex);
    }
    return distanceTo.get(vertex);
  }
  
}