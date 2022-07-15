package com.nathanwien.plsimplement.containers.lists.arraylist;

import com.nathanwien.plsimplement.containers.lists.IsIntContainer;
import com.nathanwien.plsimplement.containers.lists.IsIntList;


public class ArrayListInt implements IsIntContainer, IsIntList {
    private int[] values;
    private int size;
    private int capacity;
    private int head;
    private int tail;

    /**
     * Create an {@code ArrayList} with default capacity
     */
    ArrayListInt() {
        this.capacity = 8;
        this.size = 0;
        this.values = new int[capacity];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getFront() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("ArrayListInt is empty");
        }
        return values[head];
    }

    @Override
    public int getBack() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("ArrayListInt is empty");
        }
        return values[tail];
    }

    /**
     * Check if the array is full. If it is, allocate a bigger array and move the content
     * from the current array to the new one
     */
    void reallocateOnDemand() {
        if (size == capacity) {
            int[] newValues = new int[capacity * 2];
            for (int i = 0; i < size; i++) {
                newValues[i] = values[head];
                head = nextId(head);
            }
            head = 0;
            tail = capacity - 1;
            capacity *= 2;
            values = newValues;
        }
    }

    @Override
    public void pushFront(int value) {
        reallocateOnDemand();
        head = prevId(head);
        values[head] = value;
        size++;
    }

    @Override
    public void pushBack(int value) {
        reallocateOnDemand();
        tail = nextId(tail);
        values[tail] = value;
        size++;
    }

    @Override
    public int popFront() throws IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException("ArrayListInt is empty");
        }
        int value = values[head];
        head = nextId(head);
        return value;
    }

    @Override
    public int popBack() throws IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException("ArrayListInt is empty");
        }
        int value = values[tail];
        tail = prevId(tail);
        return value;
    }

    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            int tmp = values[(head + i) % capacity];
            values[(head + i) % capacity] = values[(tail - i) % capacity];
            values[(tail - i) % capacity] = tmp;
        }
    }

    private int prevId(int id) {
        return (id == 0) ? capacity - 1 : id - 1;
    }

    private int nextId(int id) {
        return (id == capacity - 1) ? 0 : id + 1;
    }
}