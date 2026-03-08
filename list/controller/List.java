package list.controller;

import list.model.Node;

public class List {
  private Node firstPte; // Puntero al primer nodo de la lista
  private Node currentPte; // Puntero auxiliar (actual)

  public Node getFirstPte() {
    return firstPte;
  }

  public void setFirstPte(Node firstPte) {
    this.firstPte = firstPte;
  }

  public Node getCurrentPte() {
    return currentPte;
  }

  public void setCurrentPte(Node currentPte) {
    this.currentPte = currentPte;
  }

  private boolean empty() {
    return this.firstPte == null;
  }

  public List() {
    this.currentPte = this.firstPte = null;
  }

  public boolean insertHead(int value) throws Exception {
    boolean result = true;

    try {
      Node newNode = new Node();
      newNode.setInfo(value);

      if (this.empty()) {
        newNode.setNextPte(null);
      } else {
        // Si no está vacía, el siguiente es el que era antes el primero
        newNode.setNextPte(this.firstPte);
      }

      // Actualizar el puntero de la lista para que apunte al nuevo nodo
      this.currentPte = this.firstPte = newNode;
    } catch (Exception e) {
      throw new Exception("Error al ingresar el nodo!...");
    }

    return result;
  }

  public boolean insertFinal(int value) {
    boolean result = true;

    try {
      Node newNode = new Node();
      newNode.setInfo(value);

      if (this.empty()) {
        this.currentPte = this.firstPte = newNode;
      } else {
        initializeCurrentPte();
        while (this.currentPte.getNextPte() != null) {
          this.currentPte = this.currentPte.getNextPte();
        }
        this.currentPte.setNextPte(newNode);
      }

    } catch (Exception e) {
    }
    return result;
  }

  public void initializeCurrentPte() {
    this.currentPte = this.firstPte;

  }

  public int show() {
    int result = 0;

    System.out.println(" \n Mostrando la lista \n");

    if (this.empty()) {
      result = 0;
    } else {
      result = 1;
    }
    return result;
  }

  public boolean deleteNode(int valueNode) {
    boolean result = false;
    Node previousNode = null;

    if (this.empty()) {
      result = false;
      return result;
    }

    initializeCurrentPte();

    if (this.currentPte.getInfo() == valueNode) {
      this.setFirstPte(currentPte.getNextPte());
      result = true;
      return result;
    }

    while (this.currentPte != null) {
      if (this.currentPte.getInfo() == valueNode) {
        previousNode.setNextPte(this.currentPte.getNextPte());
        result = true;
        return result;
      }
      previousNode = this.currentPte;
      this.currentPte = this.currentPte.getNextPte();
    }

    return result;
  }

  public boolean destructor() {
    boolean result = false;
    System.out.println("Metodo destructor");

    if (this.empty()) {
      result = true;
      return result;
    } else {
      this.firstPte = this.currentPte = null;
      result = true;
    }
    return result;
  }

  public boolean insertBefore(int currentValueNode, int newValue) {
    boolean result = false;
    Node previousNode = null;

    if (this.empty()) {
      return result;
    } else {
      initializeCurrentPte();
      Node newNode = new Node();

      while (this.currentPte != null) {
        if (this.currentPte.getInfo() == currentValueNode) {
          newNode.setInfo(newValue);
          newNode.setNextPte(this.currentPte);
          previousNode.setNextPte(newNode);

          result = true;
          return result;
        }
        previousNode = this.currentPte;
        this.currentPte = this.currentPte.getNextPte();
      }
    }

    return result;

  }

  public boolean insertAfter(int currentValueNode, int newValue) {
    boolean result = false;

    if (this.empty()) {
      return result;
    } else {
      initializeCurrentPte();

      while (this.currentPte != null) {
        if (this.currentPte.getInfo() == currentValueNode) {
          Node newNode = new Node();
          newNode.setInfo(newValue);
          newNode.setNextPte(this.currentPte.getNextPte());
          this.currentPte.setNextPte(newNode);
          result = true;
          return result;
        }
        this.currentPte = this.currentPte.getNextPte();
      }
    }

    return result;

  }

}
