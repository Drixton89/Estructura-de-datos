package doubleList.controller;

import doubleList.model.Node;

public class DoubleListController {

  private Node firstPte;
  private Node lastPte;
  private Node currentPte;

  public DoubleListController() {
    this.firstPte = this.lastPte = this.currentPte = null;
  }

  public Node getFirstPte() {
    return firstPte;
  }

  public void setFirstPte(Node firstPte) {
    this.firstPte = firstPte;
  }

  public Node getLastPte() {
    return lastPte;
  }

  public void setLastPte(Node lastPte) {
    this.lastPte = lastPte;
  }

  public Node getCurrentPte() {
    return currentPte;
  }

  public void setCurrentPte(Node currentPte) {
    this.currentPte = currentPte;
  }

  public boolean empty() {
    return this.firstPte == null;
  }

  public void initializeCurrentPte() {
    this.currentPte = this.firstPte;
  }

  public boolean insertLeft(int value) {
    boolean result = false;

    try {
      Node newNode = new Node();
      newNode.setInfo(value);

      if (this.empty()) {
        this.lastPte = this.firstPte = newNode;
        initializeCurrentPte();
        result = true;

      } else {
        newNode.setRightPte(this.firstPte);
        this.firstPte.setLeftPte(newNode);
        this.firstPte = newNode;
        result = true;
      }

    } catch (Exception e) {
      result = false;
    }

    return result;
  }

}
