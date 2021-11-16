package com.example.assgn2.model;

public class BST {
  private int value;
  private BST left, right;

  public BST(int value) {
    setValue(value);
    setLeft(null);
    setRight(null);
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public BST getLeft() {
    return left;
  }

  public void setLeft(BST left) {
    this.left = left;
  }

  public BST getRight() {
    return right;
  }

  public void setRight(BST right) {
    this.right = right;
  }
}
