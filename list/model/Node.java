
package list.model;

public class Node {

    private int info; // Valor almacenado en el nodo
    private Node nextPte; // Puntero al siguiente nodo en la lista

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getNextPte() {
        return nextPte;
    }

    public void setNextPte(Node nextPte) {
        this.nextPte = nextPte;
    }

    public Node() {
        this.info = 0;
        this.nextPte = null;
    }
}