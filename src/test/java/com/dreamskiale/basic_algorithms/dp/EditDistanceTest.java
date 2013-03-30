package com.dreamskiale.basic_algorithms.dp;

import org.junit.Assert;
import org.junit.Test;

public class EditDistanceTest {
  
  @Test
  public void testSimple() {
    Assert.assertEquals(0, new EditDistance().find("a", "a"));
    Assert.assertEquals(1, new EditDistance().find("a", "b"));
    Assert.assertEquals(1, new EditDistance().find("a", "ba"));
    Assert.assertEquals(1, new EditDistance().find("a", ""));
    
    Assert.assertEquals(2, new EditDistance().find("a", "bb"));

    Assert.assertEquals(6, new EditDistance().find("exponential", "polynomial"));
  }
  
}