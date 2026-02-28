
package list.model;

public class Node {

    private int info; // Valor almacenado en el nodo
    private Node nextPte; // Puntero al siguiente nodo en la lista

    // Obtiene la información almacenada en el nodo.
    public int getInfo() {
        return info;
    }

    // Establece la información en el nodo.
    public void setInfo(int info) {
        this.info = info;
    }

    // Obtiene el puntero al siguiente nodo.
    public Node getNextPte() {
        return nextPte;
    }

    // Establece el puntero al siguiente nodo.
    public void setNextPte(Node nextPte) {
        this.nextPte = nextPte;
    }

    // Constructor por defecto., Inicializa los valores por defecto: 0 para info y
    // null para el puntero.
    public Node() {
        this.info = 0;
        this.nextPte = null;
    }
}