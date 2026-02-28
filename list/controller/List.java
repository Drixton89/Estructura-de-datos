package list.controller;

import list.model.Node;

/**
 * Clase que controla las operaciones de la lista enlazada.
 */
public class List {
  private Node firstPte; // Puntero al primer nodo de la lista
  private Node currentPte; // Puntero auxiliar (actual)

  /**
   * Verifica si la lista está vacía.
   * 
   * @return true si el primer puntero es null, false de lo contrario.
   */
  private boolean empty() {
    return this.firstPte == null;
  }

  /** Constructor de la clase List. Inicializa los punteros en null. */
  public List() {
    this.currentPte = this.firstPte = null;
  }

  /**
   * Inserta un nuevo nodo al inicio de la lista.
   * 
   * @param value El valor entero a insertar.
   * @return boolean indicando si la operación fue exitosa.
   * @throws Exception Si ocurre un error durante la creación del nodo.
   */
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
      return result;
    } else {
      this.currentPte = this.firstPte;
      while (this.currentPte != null) { // hacer while en la vista 0.5,
        result = this.currentPte.getInfo();
        this.currentPte = this.currentPte.getNextPte();
      }
    }
    return result;
  }

}
