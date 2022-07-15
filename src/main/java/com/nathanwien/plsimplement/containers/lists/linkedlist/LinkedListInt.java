package com.nathanwien.plsimplement.containers.lists.linkedlist;

import com.nathanwien.plsimplement.containers.lists.IsIntContainer;
import com.nathanwien.plsimplement.containers.lists.IsIntList;

public class LinkedListInt implements IsIntContainer, IsIntList {
    private Node head;
    int size;

    public LinkedListInt() {
        head = null;
        size = 0;
    }

    /**
     * Returns the number of elements currently in the list
     *
     * @return number of elements in the list
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Checks if the list is empty
     *
     * @return {@code true} if the list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Converts the list to an array
     *
     * @return an array copy of the list
     */
    public int[] toArray() {
        int[] a = new int[size];
        Node node = head;
        for (int i = 0; i < size; i++) {
            a[i] = node.getValue();
            node = node.getNext();
        }
        return a;
    }

    /**
     * Gets the value at the front (start) of the list
     *
     * @return the value at the front of the list
     * @throws IllegalStateException with the exception message "LinkedListInt is empty" when the
     *                               list is empty
     */
    @Override
    public int getFront() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("LinkedListInt is empty");
        }
        return head.getValue();
    }

    /**
     * Gets the value at the back (end) of the list
     *
     * @return the value at the back of the list
     * @throws IllegalStateException with the exception message "LinkedListInt is empty" when the
     *                               list is empty
     */
    @Override
    public int getBack() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("LinkedListInt is empty");
        }
        return getTailNode().getValue();
    }

    /**
     * Adds a value to the front (start) of the list
     *
     * @param value the value added to the front
     */
    @Override
    public void pushFront(int value) {
        head = new Node(value, head);
        size++;
    }

    /**
     * Add a value to the front (start) of the list
     *
     * @param value the value added to the back
     */
    @Override
    public void pushBack(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            getTailNode().setNext(newNode);
        }
        size++;
    }

    /**
     * Removes and returns the value at the front (start) of the list
     *
     * @return the value popped from the front
     * @throws IllegalStateException if the list is empty
     */
    @Override
    public int popFront() throws IllegalStateException {
        if (head == null) {
            throw new IllegalStateException("LinkedListInt is empty");
        }
        int value = head.getValue();
        head = head.getNext();
        return value;
    }

    /**
     * Removes and returns the value at the back (end) of the list
     *
     * @return the value popped from the back
     * @throws IllegalStateException if the list is empty
     */
    @Override
    public int popBack() {
        if (head == null) {
            throw new IllegalStateException("LinkedListInt is empty");
        }
        int value = head.getValue();
        head = head.getNext();
        return value;
    }

    /**
     * Reverses the list
     */
    @Override
    public void reverse() {
        head = reverseFrom(head);
    }

    private Node getTailNode() throws IllegalStateException {
        if (head == null) {
            throw new IllegalStateException("LinkedListInt is empty");
        }
        return getTailNode(head);
    }

    private Node getTailNode(Node node) {
        final Node next = node.getNext();
        return next == null ? node : getTailNode(next);
    }

    private Node reverseFrom(Node node) {
        if (node == null) {
            return node;
        }
        Node next = node.getNext();
        Node newHead = reverseFrom(next);
        next.setNext(node);
        return newHead;
    }
}