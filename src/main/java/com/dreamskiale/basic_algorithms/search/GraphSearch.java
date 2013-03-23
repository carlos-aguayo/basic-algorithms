package com.dreamskiale.basic_algorithms.search;

import com.dreamskiale.basic_algorithms.pojos.Vertex;

public interface GraphSearch<T> {

  Iterable<Vertex<T>> search(Vertex<T> head);

}