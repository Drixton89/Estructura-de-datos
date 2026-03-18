package model;

public class Node {
  private int info;
  private Node rightPte;
  private Node leftPte;

  public Node() {
    this.info = 0;
    this.rightPte = null;
    this.leftPte = null;
  }

  public int getInfo() {
    return info;
  }

  public void setInfo(int info) {
    this.info = info;
  }

  public Node getRightPte() {
    return rightPte;
  }

  public void setRightPte(Node rightPte) {
    this.rightPte = rightPte;
  }

  public Node getLeftPte() {
    return leftPte;
  }

  public void setLeftPte(Node leftPte) {
    this.leftPte = leftPte;
  }

}
