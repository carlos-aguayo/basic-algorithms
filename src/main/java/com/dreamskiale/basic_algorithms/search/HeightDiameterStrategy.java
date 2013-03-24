package com.dreamskiale.basic_algorithms.search;

import com.dreamskiale.basic_algorithms.pojos.Vertex;

public class HeightDiameterStrategy implements DiameterStrategy {
  
  @Override
  public <T> int getDiameter(Vertex<T> start) {
    int maxHeightAdjacents = 0;
    for (Vertex<T> u : start.getAdjacent()) {
      for (Vertex<T> v : start.getAdjacent()) {
        if (u != v) {
          maxHeightAdjacents = Math.max(maxHeightAdjacents, u.getHeight() + v.getHeight() + 3);
        }
      }
    }
    
    int maxDiameterAdjacents = 0;
    for (Vertex<T> v : start.getAdjacent()) {
      maxDiameterAdjacents = Math.max(maxDiameterAdjacents, v.getDiameter(this));
    }
    return Math.max(maxHeightAdjacents, maxDiameterAdjacents);
  }
  
}