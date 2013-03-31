package com.dreamskiale.basic_algorithms.pojos;

import java.util.List;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;


public class UndirectedWeightedGraph<T> {
  
  private final List<T> nodes;
  
  private SortedSet<Edge<T>> edges;
  
  public static class Edge<T> implements Comparable<Edge<T>> {
    public final T u;
    public final T v;
    public final int weight;
    
    public Edge(T u, T v, int weight) {
      this.u = u;
      this.v = v;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge<T> other) {
      if (this.equals(other)) {
        return 0;
      } if (this.weight == other.weight) {
        return -1;
      } else {
        return Integer.valueOf(this.weight).compareTo(Integer.valueOf(other.weight));
      }
    }
    
    @Override
    public String toString() {
      return "[" + u + "-->" + v + ", weight: " + weight + "]";
    }

    @Override
    public int hashCode() {
      return Objects.hash(u, v);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      @SuppressWarnings("unchecked")
      Edge<T> other = (Edge<T>) obj;
      if (Objects.equals(this.u, other.u) && Objects.equals(this.v, other.v)) {
        return true;
      }
      if (Objects.equals(this.u, other.v) && Objects.equals(this.v, other.u)) {
        return true;
      }
      return false;
    }
  }
  
  public UndirectedWeightedGraph(List<T> nodes) {
    this.nodes = nodes;
    edges = new TreeSet<>();
  }
  
  public void setEdge(T u, T v, int weight) {
    edges.add(new Edge<T>(u, v, weight));
  }
  
  public SortedSet<Edge<T>> getEdges() {
    return edges;
  }
  
  public List<T> getNodes() {
    return nodes;
  }
  
}