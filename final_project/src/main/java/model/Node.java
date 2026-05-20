package model;

public class Node {

    public ModelBook data;
    public Node next;

    public Node(ModelBook data) {
        this.data = data;
        this.next = null;
    }
}
