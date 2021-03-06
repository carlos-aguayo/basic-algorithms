package com.dreamskiale.basic_algorithms.search;

import com.dreamskiale.basic_algorithms.pojos.Vertex;

public class BFSDiameterStrategy implements DiameterStrategy {
  
  /**
   * Run BFS on any node s in the graph, remembering the node u discovered last. Run BFS from u
   * remembering the node v discovered last. d(u,v) is the diameter of the tree. 
   * 
   * http://courses.csail.mit.edu/6.046/fall01/handouts/ps9sol.pdf
   */
  @Override
  public <T> int getDiameter(Vertex<T> s) {
    BreadthFirstSearch<T> bfs = new BreadthFirstSearch<>();
    
    bfs.search(s);
    Vertex<T> u = bfs.getLastVertexVisited();
    
    bfs.search(u);
    Vertex<T> v = bfs.getLastVertexVisited();
    
    return bfs.distanceTo(v) + 1;
  }
  
}