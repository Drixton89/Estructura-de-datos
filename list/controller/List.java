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
    Node previousNode = this.firstPte;

    if (this.empty()) {
      result = false;
      return result;
    } else {
      initializeCurrentPte();
      if (this.currentPte.getInfo() == valueNode && this.currentPte.getNextPte() == null) {
        this.setCurrentPte(null);
        this.setFirstPte(null);
        result = true;
      }

      while (this.currentPte.getNextPte() != null) {

        System.out.println("currentgetinfo : " + this.currentPte.getInfo());

        if (this.currentPte.getInfo() == valueNode) {
          previousNode.setNextPte(this.currentPte.getNextPte());
          this.setCurrentPte(previousNode);
          result = true;
        }
        previousNode = this.currentPte;
        this.currentPte = this.currentPte.getNextPte();
      }

    }

    return result;
  }

}
