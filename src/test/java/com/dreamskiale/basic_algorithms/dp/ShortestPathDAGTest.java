package com.dreamskiale.basic_algorithms.dp;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dreamskiale.basic_algorithms.pojos.Vertex;
import com.dreamskiale.basic_algorithms.utils.GraphUtils;


public class ShortestPathDAGTest {
  
  @Test
  public void shortestTest() {
    List<Vertex<String>> dag = GraphUtils.buildGraph5();
    
    ShortestPathDAG<String> shortest = new ShortestPathDAG<String>();
    
    int s = shortest.search(dag, GraphUtils.getVertex(dag, "S"), GraphUtils.getVertex(dag, "E"));
    Assert.assertEquals(3, s);
  }
  
}