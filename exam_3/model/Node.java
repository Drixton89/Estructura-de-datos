
package exam_3.model;

public class Node {
    private byte value;
    private Node nextPte;

    public Node() {
        this.value = 0;
        this.nextPte = null;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public Node getNextPte() {
        return nextPte;
    }

    public void setNextPte(Node nextPte) {
        this.nextPte = nextPte;
    }
}