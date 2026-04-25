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

  public void insertNode(int data) {
    Node newNode = new Node();
    newNode.setValue(data);
    if (isEmpty(root)) {
      root = newNode;
    } else {
      insertNodeRecursive(root, newNode);
    }
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

  public void deleteNode(int data) {
    if (isEmpty(root)) {
      System.out.println("El arbol esta vacio.");
      return;
    }
    root = deleteNodeRecursive(root, data);
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

  public void searchNode(int data) {
    if (isEmpty(root)) {
      System.out.println("El arbol esta vacio.");
      return;
    }
    boolean found = searchNodeRecursive(root, data);
    if (found) {
      System.out.println("Nodo " + data + " encontrado en el arbol.");
    } else {
      System.out.println("Nodo " + data + " no encontrado en el arbol.");
    }
  }

  private boolean searchNodeRecursive(Node current, int data) {
    if (isEmpty(current)) return false;
    if (data == current.getValue()) return true;
    if (data < current.getValue()) return searchNodeRecursive(current.getLeft(), data);
    return searchNodeRecursive(current.getRight(), data);
  }

  public void printTree() {
    if (isEmpty(root)) {
      System.out.println("El arbol esta vacio.");
      return;
    }
    System.out.println("Recorrido en orden (inorden):");
    printInOrder(root);
    System.out.println();
  }

  private void printInOrder(Node current) {
    if (isEmpty(current)) return;
    printInOrder(current.getLeft());
    System.out.print(current.getValue() + " ");
    printInOrder(current.getRight());
  }
}
