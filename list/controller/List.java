package list.controller;

import list.model.Node;

public class List {
  private Node firstPte;
  private Node currentPte;

  private boolean empty() {
    return this.firstPte == null;

  }

  public List() {
    this.currentPte = this.firstPte = null;
  }

  public boolean insertHead(int value)
      throws Exception {
    boolean result = true;

    try {
      Node newNode = new Node();
      newNode.setInfo(value);

      if (this.empty()) {
        newNode.setNextPte(null);
      } else {
        newNode.setNextPte(this.firstPte);
      }

      this.firstPte = newNode;
    } catch (Exception e) {
      throw new Exception("Error al ingresar el nodo!...");
    }

    return result;
  }

}
