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

  public boolean insertRight(int value) {
    boolean result = false;

    try {
      Node newNode = new Node();
      newNode.setInfo(value);

      if (this.empty()) {
        this.lastPte = this.firstPte = newNode;
        initializeCurrentPte();
        result = true;

      } else {
        newNode.setLeftPte(this.lastPte);
        this.lastPte.setRightPte(newNode);
        this.lastPte = newNode;
        result = true;
      }

    } catch (Exception e) {
      result = false;
    }

    return result;
  }

  public boolean showList() {
    boolean result = false;

    if (this.empty()) {
      result = false;
    } else {
      result = true;
    }
    return result;
  }

  public boolean deleteNode(int value) {
    if (this.empty()) {
      return false;
    }

    // Buscar el nodo con el valor
    Node auxiliarNode = this.firstPte;
    while (auxiliarNode != null && auxiliarNode.getInfo() != value) {
      auxiliarNode = auxiliarNode.getRightPte();
    }

    // No se encontró
    if (auxiliarNode == null) {
      return false;
    }

    // Caso 1: único nodo en la lista
    if (auxiliarNode == this.firstPte && auxiliarNode == this.lastPte) {
      this.firstPte = this.lastPte = null;

      // Caso 2: es el primer nodo
    } else if (auxiliarNode == this.firstPte) {
      this.firstPte = auxiliarNode.getRightPte();
      this.firstPte.setLeftPte(null);

      // Caso 3: es el último nodo
    } else if (auxiliarNode == this.lastPte) {
      this.lastPte = auxiliarNode.getLeftPte();
      this.lastPte.setRightPte(null);

      // Caso 4: nodo en el medio
    } else {
      auxiliarNode.getLeftPte().setRightPte(auxiliarNode.getRightPte());
      auxiliarNode.getRightPte().setLeftPte(auxiliarNode.getLeftPte());
    }

    this.currentPte = this.firstPte;
    return true;
  }

}
