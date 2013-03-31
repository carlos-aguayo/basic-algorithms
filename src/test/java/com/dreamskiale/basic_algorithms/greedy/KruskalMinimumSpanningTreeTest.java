package com.dreamskiale.basic_algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.dreamskiale.basic_algorithms.pojos.UndirectedWeightedGraph.Edge;
import com.dreamskiale.basic_algorithms.utils.GraphUtils;

public class KruskalMinimumSpanningTreeTest {
  
  @Test
  public void testSimple1() {
    List<Edge<String>> mst = new KruskalMinimumSpanningTree<String>().findMST(GraphUtils.buildGraph6());
    
    List<Edge<String>> expectedEdges = new ArrayList<>();
    expectedEdges.add(new Edge<String>("A", "C", 1));
    expectedEdges.add(new Edge<String>("B", "D", 1));
    expectedEdges.add(new Edge<String>("E", "F", 1));

    expectedEdges.add(new Edge<String>("C", "D", 2));
    expectedEdges.add(new Edge<String>("C", "E", 3));
    
    Assert.assertEquals(expectedEdges.size(), mst.size());
    
    for (Edge<String> edge : mst) {
      Assert.assertTrue("Edge " + edge + " is not contained in the expected edges", expectedEdges.contains(edge));
    }
  }

  @Test
  public void testSimple2() {
    List<Edge<String>> mst = new KruskalMinimumSpanningTree<String>().findMST(GraphUtils.buildGraph7());
    
    List<Edge<String>> expectedEdges = new ArrayList<>();
    expectedEdges.add(new Edge<String>("B", "C", 1));
    expectedEdges.add(new Edge<String>("C", "D", 2));
    expectedEdges.add(new Edge<String>("C", "F", 3));
    expectedEdges.add(new Edge<String>("A", "D", 4));
    expectedEdges.add(new Edge<String>("E", "F", 4));
    
    Assert.assertEquals(expectedEdges.size(), mst.size());
    
    for (Edge<String> edge : mst) {
      Assert.assertTrue("Edge " + edge + " is not contained in the expected edges", expectedEdges.contains(edge));
    }
  }
  
}