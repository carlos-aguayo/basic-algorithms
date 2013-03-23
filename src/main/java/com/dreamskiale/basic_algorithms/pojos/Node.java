package com.dreamskiale.basic_algorithms.pojos;

public class Node<T> {

  private final Node<T> left;
  private final Node<T> right;
  private final T value;

  public Node(T value, Node<T> left, Node<T> right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
  
  public Node<T> getLeft() {
    return left;
  }

  public Node<T> getRight() {
    return right;
  }

  public T getValue() {
    return value;
  }

}