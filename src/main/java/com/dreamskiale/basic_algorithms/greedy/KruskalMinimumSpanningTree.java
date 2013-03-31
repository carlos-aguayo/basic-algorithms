package com.dreamskiale.basic_algorithms.greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.dreamskiale.basic_algorithms.pojos.UndirectedWeightedGraph;
import com.dreamskiale.basic_algorithms.pojos.UndirectedWeightedGraph.Edge;


public class KruskalMinimumSpanningTree<T> {
  
  // I wanted to use Sets instead of Lists but ran into this:
  // http://blog.martindoms.com/2010/07/27/the-broken-java-set-interface/
  private List<List<T>> sets;
  
  public List<Edge<T>> findMST(UndirectedWeightedGraph<T> graph) {
    sets = new LinkedList<>();
    
    List<Edge<T>> mst = new ArrayList<>();
    
    for (T node : graph.getNodes()) {
      List<T> s = new LinkedList<>();
      s.add(node);
      sets.add(s);
    }
    
    for (Edge<T> e : graph.getEdges()) {
      List<T> su = find(e.u);
      List<T> sv = find(e.v);
      if (su != sv) {
        mst.add(e);
        union(su, sv);
      }
    }
    
    return mst;
  }
  
  private void union(List<T> s1, List<T> s2) {
    sets.remove(s2);
    s1.addAll(s2);
  }
  
  private List<T> find(T node) {
    for (List<T> s : sets) {
      if (s.contains(node)) {
        return s;
      }
    }
    return null;
  }

 
}