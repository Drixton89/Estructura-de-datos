package controller;

import java.util.LinkedList;
import java.util.List;
import model.Node;

public class Controller {
  private Node root;

  public Controller() {
    this.root = null;
  }

  private boolean isEmpty(Node node) {
    return node == null;
  }

  public boolean insertNode(int data) {
    Node newNode = new Node();
    boolean result = false;

    newNode.setValue(data);
    if (isEmpty(root)) {
      root = newNode;
      result = true;
    } else {
      insertNodeRecursive(root, newNode);
      result = true;
    }
    return result;
  }

  private void insertNodeRecursive(Node current, Node newNode) {
    if (newNode.getValue() < current.getValue()) {
      if (isEmpty(current.getLeft())) {
        current.setLeft(newNode);
      } else {
        insertNodeRecursive(current.getLeft(), newNode);
      }
    } else if (newNode.getValue() > current.getValue()) {
      if (isEmpty(current.getRight())) {
        current.setRight(newNode);
      } else {
        insertNodeRecursive(current.getRight(), newNode);
      }
    }
  }

  public boolean searchNode(int data) {
    boolean result = false;

    if (isEmpty(root)) {
      return result;
    } else {
      result = searchNodeRecursive(root, data);
    }
    return result;
  }

  private boolean searchNodeRecursive(Node current, int data) {
    if (isEmpty(current)) return false;
    if (data == current.getValue()) return true;
    if (data < current.getValue()) return searchNodeRecursive(current.getLeft(), data);
    return searchNodeRecursive(current.getRight(), data);
  }

  public List<Integer> inOrderTraversal() {
    List<Integer> list = new LinkedList<>();
    if (!isEmpty(root)) {
      inOrder(root, list);
    }
    return list;
  }

  private void inOrder(Node current, List<Integer> list) {
    if (isEmpty(current)) return;
    inOrder(current.getLeft(), list);
    list.add(current.getValue());
    inOrder(current.getRight(), list);
  }

  public List<Integer> preOrderTraversal() {
    List<Integer> list = new LinkedList<>();
    if (!isEmpty(root)) {
      preOrder(root, list);
    }
    return list;
  }

  private void preOrder(Node current, List<Integer> list) {
    if (isEmpty(current)) return;
    list.add(current.getValue());
    preOrder(current.getLeft(), list);
    preOrder(current.getRight(), list);
  }
}
