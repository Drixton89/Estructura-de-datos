package stack.controller;

import stack.model.Node;

public class StackController {

  public Node topPte;

  public StackController() {
    this.topPte = null;
  }

  public boolean isEmpty() {
    return this.topPte == null;
  }

  public boolean pushNode(int info) {

    boolean result;
    Node newNode = new Node();

    try {
      newNode.setInfo(info);
      newNode.setNextPte(this.topPte);
      this.topPte = newNode;
      result = true;

    } catch (Exception e) {
      System.out.println("Error al crear el nodo");
      result = false;
    }
    return result;
  }

  public boolean popNode() {

    boolean result = false;

    if (isEmpty()) {
      System.out.println("La pila esta vacia");
    } else {  
      this.topPte = this.topPte.getNextPte();
      result = true;
    }
    return result;
  }

  public boolean showStack() {
    boolean result = false;

    if (isEmpty()) {
      result = false;
    } else {  
      result = true;
    }
    return result; 
  }
}
