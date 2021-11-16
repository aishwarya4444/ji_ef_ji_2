package com.example.assgn2.service;

import com.example.assgn2.model.BST;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BSTService {
  private BST root;

  public BSTService() {
    this.root = null;
  }

  /*
  *
  * referred add/delete/search from
  * https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
  *
  * */

  /* add a key */

  public void add(int key) {
    root = add(root, key);
  }

  private BST add(BST root, int key) {
    if(root == null) {
      root = new BST(key);
      return root;
    }

    if(key < root.getValue()) {
      root.setLeft(add(root.getLeft(), key));
    } else {
      root.setRight(add(root.getRight(), key));
    }

    return root;
  }

  /* delete a key */

  public void delete(int key) {
    root = delete(root, key);
  }

  private BST delete(BST root, int key) {
    if (root == null)
      return root;

    if (key < root.getValue())
      root.setLeft(delete(root.getLeft(), key));
    else if (key > root.getValue())
      root.setRight(delete(root.getRight(), key));
    else {
      // node with only one child or no child
      if (root.getLeft() == null)
        return root.getRight();
      else if (root.getRight() == null)
        return root.getLeft();

      // node with two children: Get the inorder
      // successor (smallest in the right subtree)
      root.setValue(minValue(root.getRight()));

      // Delete the inorder successor
      root.setRight(delete(root.getRight(), root.getValue()));
    }

    return root;
  }

  private int minValue(BST root) {
    int minVal = root.getValue();
    while (root.getLeft() != null)
    {
      minVal = root.getLeft().getValue();
      root = root.getLeft();
    }
    return minVal;
  }

  /* read all keys */

  public List<Integer> read() {
    List<Integer> result = new ArrayList<>();
    inorder(root, result);
    return result;
  }

  private void inorder(BST root, List<Integer> result) {
    if(root == null) return;

    inorder(root.getLeft(), result);
    result.add(root.getValue());
    inorder(root.getRight(), result);
  }
}
