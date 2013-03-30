package com.dreamskiale.basic_algorithms.pojos;

import java.util.LinkedList;
import java.util.List;

import com.dreamskiale.basic_algorithms.search.DiameterStrategy;

public class Vertex<T>{
  
  private final List<Vertex<T>> adjacent = new LinkedList<>();
  private final List<Vertex<T>> incoming = new LinkedList<>();
  private final T value;

  public Vertex(T value) {
    this.value = value;
  }
  
  /**
   * If undirected graph, list of adjacent vertices.
   * If directed graph, list of outgoing vertices.
   */
  public List<Vertex<T>> getAdjacent() {
    return adjacent;
  }
  
  /**
   * In directed graph, this are the vertices that point to this vertex.
   */
  public List<Vertex<T>> getIncoming() {
    return incoming;
  }

  public T getValue() {
    return value;
  }
  
  public int getDiameter(DiameterStrategy diameterStrategy) {
    return diameterStrategy.getDiameter(this);
  }
  
  public int getHeight() {
    int height = 0;
    for (Vertex<T> v : adjacent) {
      height = Math.max(height, v.getHeight() + 1);
    }
    return height;
  }
  
  @Override
  public String toString() {
    return value.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Vertex<?> other = (Vertex<?>) obj;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }
  
}