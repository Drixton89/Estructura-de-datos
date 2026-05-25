package Controller;

import model.Node;

public class Controller {

  Node root;

  public Controller() {
    this.root = null;
  }

  private boolean isEmpty(Node node) {
    return node == null;
  }

  // add node
  public boolean insertNode(int data) {
    Node newNode = new Node(data);
    boolean result = false;

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

  // quantity
  public int quantityOfNodes() {
    int result;

    if (isEmpty(root)) {
      result = 0;
    } else {
      result = quantityOfNodesRecursive(root);
    }

    return result;
  }

  private int quantityOfNodesRecursive(Node node) {
    int value_root = 1;
    if (isEmpty(node)) {
      return 0;
    }
    return value_root + quantityOfNodesRecursive(node.getLeft()) + quantityOfNodesRecursive(node.getRight());
  }

  public boolean searchNode(int valueToFind) {
    return searchNodeRecursive(root, valueToFind);
  }

  // search node
  private boolean searchNodeRecursive(Node current, int valueToFind) {
    if (isEmpty(current)) {
      return false;
    }
    if (valueToFind == current.getValue()) {
      return true;
    }
    if (valueToFind < current.getValue()) {
      return searchNodeRecursive(current.getLeft(), valueToFind);
    }
    return searchNodeRecursive(current.getRight(), valueToFind);
  }

}
