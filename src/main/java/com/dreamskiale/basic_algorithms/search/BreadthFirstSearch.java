package com.dreamskiale.basic_algorithms.search;

import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.dreamskiale.basic_algorithms.pojos.Vertex;

public class BreadthFirstSearch<T> implements GraphSearch<T> {

  private Set<Vertex<T>> visited = new LinkedHashSet<>();
  protected Deque<Vertex<T>> q = new LinkedList<>();

  @Override
  public Iterable<Vertex<T>> search(Vertex<T> head) {
    visited.clear();
    
    q.addFirst(head);
    visit(head);
    
    while(!q.isEmpty()) {
      Vertex<T> v = q.removeLast();
      List<Vertex<T>> adj = v.getAdjacent();
      for (Vertex<T> a : adj) {
        if (!visited.contains(a)) {
          visit(a);
          q.addFirst(a);
        }
      }
    }
    
    return visited;
  }
  
  private void visit(Vertex<T> v) {
    visited.add(v);
  }

}