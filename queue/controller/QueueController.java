package controller;

import model.Node;

public class QueueController {
  private Node firstPte;
  private Node lastPte;

  public QueueController() {
    this.firstPte = null;
    this.lastPte = null;
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

  public boolean isEmpty() {
    return this.firstPte == null && this.lastPte == null;
  }

  public boolean insertData(int data) {
    boolean result = false;
    Node newNode = new Node();
    newNode.setInfo(data);

    if (isEmpty()) {
      this.firstPte = newNode;
      this.lastPte = newNode;
      result = true;
    } else {
      this.lastPte.setNext(newNode);
      this.lastPte = newNode;
      result = true;
    }

    return result;
  }

  public int showFirst() {
    int result = -1;
    if (isEmpty()) {
      result = -1;
    } else {
      result = this.firstPte.getInfo();
    }
    return result;
  }

  public int showLast() {
    int result = -1;
    if (isEmpty()) {
      result = -1;
    } else {
      result = this.lastPte.getInfo();
    }
    return result;
  }

  public int unQueue() {
    int result = -1;
    if (isEmpty()) {
      result = -1;
    } else {

      result = this.firstPte.getInfo();

      if (this.firstPte == this.lastPte) {
        this.lastPte = null;
      }

      this.firstPte = this.firstPte.getNext();

    }
    return result;
  }

  public int showQueueOriginal(){
    int result = -1;
    Node temp = this.firstPte;
    
    while (temp != null) {
      result = temp.getInfo();
      temp = temp.getNext();
    }
    return result;
  }

}
