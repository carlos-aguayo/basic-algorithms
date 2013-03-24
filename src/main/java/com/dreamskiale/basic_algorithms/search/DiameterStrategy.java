package com.dreamskiale.basic_algorithms.search;

import com.dreamskiale.basic_algorithms.pojos.Vertex;

public interface DiameterStrategy {
  
  <T> int getDiameter(Vertex<T> vertex);
  
}