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
     * Counts the real number of nodes in the list (mainly for testing purpose)
     */
    public int getNodeCount() {
        Node cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.getNext();
        }
        return count;
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
     * Adds a value to the front (start) of the list
     *
     * @param value the value added to the front
     */
    @Override
    public void pushFront(int value) {
        throw new RuntimeException("Unimplemented");
    }

    /**
     * Add a value to the front (start) of the list
     *
     * @param value the value added to the back
     */
    @Override
    public void pushBack(int value) {
        throw new RuntimeException("Unimplemented");
    }

    /**
     * Reverses the list
     */
    @Override
    public void reverse() {
        throw new RuntimeException("Unimplemented");
    }
}