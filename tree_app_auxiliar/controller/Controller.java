package controller;

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

  public boolean deleteNode(int data) {
    boolean result = false;

    if (isEmpty(root)) {
      System.out.println("El arbol esta vacio.");
      return result;
    }
    root = deleteNodeRecursive(root, data);
    result = true;
    return result;
  }

  private Node deleteNodeRecursive(Node current, int data) {
    if (isEmpty(current)) {
      System.out.println("El nodo " + data + " no existe en el arbol.");
      return null;
    }
    if (data < current.getValue()) {
      current.setLeft(deleteNodeRecursive(current.getLeft(), data));
    } else if (data > current.getValue()) {
      current.setRight(deleteNodeRecursive(current.getRight(), data));
    } else {
      // nodo encontrado
      if (isEmpty(current.getLeft())) return current.getRight();
      if (isEmpty(current.getRight())) return current.getLeft();
      // dos hijos: reemplazar con el menor del subárbol derecho
      int minValue = findMin(current.getRight());
      current.setValue(minValue);
      current.setRight(deleteNodeRecursive(current.getRight(), minValue));
    }
    return current;
  }

  private int findMin(Node node) {
    while (!isEmpty(node.getLeft())) {
      node = node.getLeft();
    }
    return node.getValue();
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

  public boolean printTree() {
    boolean result = false;

    if (isEmpty(root)) {
      return result;
    } else {
      printInOrder(root);
      result = true;
    }
    return result;
  }

  private void printInOrder(Node current) {
    printInOrder(current.getLeft());
    System.out.print(current.getValue() + " ");
    printInOrder(current.getRight());
  }
}
