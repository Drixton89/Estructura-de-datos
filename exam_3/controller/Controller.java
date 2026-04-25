
package exam_3.controller;

import exam_3.model.Node;

public class Controller {
  public Node topPte;

  public Controller() {
    this.topPte = null;
  }

  public boolean isEmpty() {
    return this.topPte == null;
  }

  public boolean pushNode(byte value) {

    boolean result;
    Node newNode = new Node();

    try {
      newNode.setValue(value);
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
    boolean result;
    if (isEmpty()) {
      result = false;
    } else {
      this.topPte = this.topPte.getNextPte();
      result = true;
    }
    return result;
  }

}