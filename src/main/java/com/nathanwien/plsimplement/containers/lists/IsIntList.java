package com.nathanwien.plsimplement.containers.lists;

public interface IsIntList {
    // int getFront() throws IllegalStateException;

    // int getBack() throws IllegalStateException;

    // int popFront() throws IllegalStateException;

    // int popBack() throws IllegalStateException;

    void pushFront(int value);

    void pushBack(int value);

    void reverse();
}