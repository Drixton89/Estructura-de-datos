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

  // Inserta un nuevo nodo al inicio de la lista.
  public boolean insertHead(int value) throws Exception {
    boolean result = true;

    try {
      // 1. Crear un nuevo nodo
      Node newNode = new Node();
      // 2. Asignar el valor al nuevo nodo
      newNode.setInfo(value);

      // 3. Establecer el enlace del nuevo nodo
      if (this.empty()) {
        // Si la lista está vacía, el siguiente es null
        newNode.setNextPte(null);
      } else {
        // Si no está vacía, el siguiente es el que era antes el primero
        newNode.setNextPte(this.firstPte);
      }

      // 4. Actualizar el puntero de la lista para que apunte al nuevo nodo
      this.currentPte = this.firstPte = newNode;
    } catch (Exception e) {
      // Lanzar excepción en caso de error
      throw new Exception("Error al ingresar el nodo!...");
    }

    return result;
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

}
