package com.dreamskiale.basic_algorithms.search;

import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.dreamskiale.basic_algorithms.pojos.Vertex;

public class KahnTopologicalSort<T> {

  /**
   * http://en.wikipedia.org/wiki/Topological_sorting#Algorithms
   * Kahn (1962)
   * 
   * L ← Empty list that will contain the sorted elements
   * S ← Set of all nodes with no incoming edges
   * while S is non-empty do
   *   remove a node n from S
   *   insert n into L
   *   for each node m with an edge e from n to m do
   *     remove edge e from the graph
   *     if m has no other incoming edges then
   *       insert m into S
   * if graph has edges then
   *   return error (graph has at least one cycle)
   * else 
   *   return L (a topologically sorted order)
   */
  public Deque<Vertex<T>> getTopologicalSort(List<Vertex<T>> directedAcyclicalGraph) {
    // L ← Empty list that will contain the sorted elements
    Deque<Vertex<T>> l = new LinkedList<>();
    
    // S ← Set of all nodes with no incoming edges
    Set<Vertex<T>> noIncomingEdges = buildNoIncomingEdges(directedAcyclicalGraph);
    
    // while S is non-empty do
    while (!noIncomingEdges.isEmpty()) {
      
      // remove a node n from S
      Vertex<T> v = noIncomingEdges.iterator().next();
      noIncomingEdges.remove(v);
      
      // insert n into L
      l.addLast(v);
      
      // for each node m with an edge e from n to m do
      for (Vertex<T> a : v.getAdjacent()) {
        // remove edge e from the graph
        a.getIncoming().remove(v);
        // if m has no other incoming edges then
        if (a.getIncoming().isEmpty()) {
          // insert m into S
          noIncomingEdges.add(a);
        }
      }
    }
    
    // return L (a topologically sorted order)
    return l;
  }
  
  private Set<Vertex<T>> buildNoIncomingEdges(List<Vertex<T>> graph) {
    Set<Vertex<T>> noIncomingEdges = new LinkedHashSet<>(graph);
    for (Vertex<T> v : graph) {
      if (!v.getIncoming().isEmpty()) {
        noIncomingEdges.remove(v);
      }
    }
    return noIncomingEdges;
  }
  

}