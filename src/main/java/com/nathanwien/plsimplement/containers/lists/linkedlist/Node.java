package com.nathanwien.plsimplement.containers.lists.linkedlist;

public class Node {
    private final int value;
    private Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(int value) {
        this(value, null);
    }

    /**
     * Gets the value of the node
     *
     * @return the value of the node
     */
    public int getValue() {
        return value;
    }

    /**
     * Gets the next node
     *
     * @return the next node in the list
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the next node to be the node {@code next}
     *
     * @param next the new next node
     */
    public void setNext(Node next) {
        this.next = next;
    }
}