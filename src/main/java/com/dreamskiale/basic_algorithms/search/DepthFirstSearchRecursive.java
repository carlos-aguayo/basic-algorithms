package com.dreamskiale.basic_algorithms.search;

import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.dreamskiale.basic_algorithms.pojos.Vertex;

public class DepthFirstSearchRecursive<T> implements GraphSearch<T> {

  private Set<Vertex<T>> visited = new LinkedHashSet<>();
  private Deque<Vertex<T>> topologicalSort = new LinkedList<>();

  @Override
  public Iterable<Vertex<T>> search(Vertex<T> head) {
    visited.clear();
    topologicalSort.clear();
    dfsRecursive(head);
    return visited;
  }
  
  public Iterable<Vertex<T>> dfs(List<Vertex<T>> graph) {
    visited.clear();
    topologicalSort.clear();
    for (Vertex<T> v : graph) {
      if (!visited.contains(v)) {
        dfsRecursive(v);
      }
    }
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
    topologicalSort.addFirst(vertex);
  }
  
  /**
   * CLRS pag 613
   * TOPOLOGICAL-SORT(G)
   * 1. Call DFS(G) to compute finishing times v.f for each vertex v
   * 2. As each vertex is finished, insert it onto the front of a linked list 
   * 3. return the linked list of vertices
   */
  public Deque<Vertex<T>> getTopologicalSort() {
    return topologicalSort;
  }
  
  private void visit(Vertex<T> v) {
    visited.add(v);
  }

}