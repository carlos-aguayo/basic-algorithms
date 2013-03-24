package com.dreamskiale.basic_algorithms.search;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dreamskiale.basic_algorithms.pojos.Vertex;

public class BreadthFirstSearch<T> implements GraphSearch<T> {

  private final Set<Vertex<T>> visited = new LinkedHashSet<>();
  private final Deque<Vertex<T>> queue = new LinkedList<>();
  private final Map<Vertex<T>, Integer> distance = new HashMap<>();
  private final Map<Vertex<T>, Vertex<T>> parent = new HashMap<>();
  private Vertex<T> lastVertexVisited;

  @Override
  public Iterable<Vertex<T>> search(Vertex<T> start) {
    visited.clear();
    queue.clear();
    distance.clear();
    parent.clear();
    
    visit(start);
    queue.addFirst(start);
    parent.put(start, null);
    distance.put(start, 0);
    
    while(!queue.isEmpty()) {
      Vertex<T> u = queue.removeLast();
      List<Vertex<T>> adj = u.getAdjacent();
      for (Vertex<T> v : adj) {
        if (!visited.contains(v)) {
          visit(v);
          queue.addFirst(v);
          parent.put(v, u);
          distance.put(v, distance.get(u) + 1);
        }
      }
    }
    
    return visited;
  }
  
  public Vertex<T> getLastVertexVisited() {
    return lastVertexVisited;
  }
  
  public int distanceTo(Vertex<T> vertex) {
    return distance.get(vertex);
  }
  
  public Vertex<T> parentOf(Vertex<T> vertex) {
    return parent.get(vertex);
  }
  
  private void visit(Vertex<T> v) {
    visited.add(v);
    lastVertexVisited = v;
  }

}