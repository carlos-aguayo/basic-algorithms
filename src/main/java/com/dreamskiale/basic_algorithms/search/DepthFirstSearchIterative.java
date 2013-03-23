package com.dreamskiale.basic_algorithms.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.dreamskiale.basic_algorithms.pojos.Vertex;

public class DepthFirstSearchIterative<T> implements GraphSearch<T> {

  private Set<Vertex<T>> visited = new LinkedHashSet<>();

  @Override
  public Iterable<Vertex<T>> search(Vertex<T> head) {
    visited.clear();
    dfsIterative(head);
    return visited;
  }
  
  private void dfsIterative(Vertex<T> vertex) {
    Deque<Vertex<T>> stack = new LinkedList<>();
    stack.push(vertex);
    while (!stack.isEmpty()) {
      Vertex<T> n = stack.pop();
      if (!visited.contains(n)) {
        visit(n);
        List<Vertex<T>> reversed = new ArrayList<>(n.getAdjacent());
        Collections.reverse(reversed);
        for (Vertex<T> v : reversed) { 
          stack.push(v); 
        }
      }
    }
  }
  
  private void visit(Vertex<T> v) {
    visited.add(v);
  }

}