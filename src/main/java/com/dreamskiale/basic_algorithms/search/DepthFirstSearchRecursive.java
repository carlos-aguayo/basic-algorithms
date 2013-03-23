package com.dreamskiale.basic_algorithms.search;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.dreamskiale.basic_algorithms.pojos.Vertex;

public class DepthFirstSearchRecursive<T> implements GraphSearch<T> {

  private Set<Vertex<T>> visited = new LinkedHashSet<>();

  @Override
  public Iterable<Vertex<T>> search(Vertex<T> head) {
    visited.clear();
    dfsRecursive(head);
    return visited;
  }
  
  private void dfsRecursive(Vertex<T> vertex) {
    visit(vertex);
    List<Vertex<T>> adj = vertex.getAdjacent();
    for (Vertex<T> a : adj) {
      if (!visited.contains(a)) {
        dfsRecursive(a);
      }
    }
  }
  
  private void visit(Vertex<T> v) {
    visited.add(v);
  }

}