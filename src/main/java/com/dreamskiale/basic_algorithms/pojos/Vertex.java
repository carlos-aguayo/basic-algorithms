package com.dreamskiale.basic_algorithms.pojos;

import java.util.LinkedList;
import java.util.List;

import com.dreamskiale.basic_algorithms.search.DiameterStrategy;

public class Vertex<T>{
  
  private final List<Vertex<T>> adjacent = new LinkedList<>();
  private final T value;

  public Vertex(T value) {
    this.value = value;
  }
  
  public List<Vertex<T>> getAdjacent() {
    return adjacent;
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
  
}