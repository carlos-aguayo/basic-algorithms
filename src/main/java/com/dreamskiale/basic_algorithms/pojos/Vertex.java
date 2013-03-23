package com.dreamskiale.basic_algorithms.pojos;

import java.util.LinkedList;
import java.util.List;

public class Vertex<T> {
  
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
  
  @Override
  public String toString() {
    return value.toString();
  }

}