package com.nathanwien.plsimplement.containers.lists;

import com.nathanwien.plsimplement.containers.lists.linkedlist.LinkedListInt;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

public class LinkedListIntTest {
    @Property
    boolean pushBackCorrectly(@ForAll int[] pushOrder) {
        LinkedListInt linkedList = new LinkedListInt();
        for (int value : pushOrder) {
            linkedList.pushBack(value);
        }
        return areEqual(pushOrder, linkedList);
    }

    @Property
    boolean pushFrontCorrectly(@ForAll int[] pushOrder) {
        LinkedListInt linkedList = new LinkedListInt();
        for (int value : pushOrder) {
            linkedList.pushFront(value);
        }
        return areEqual(reverse(pushOrder), linkedList);
    }

    @Property
    boolean reverseCorrectly(@ForAll int[] pushBackOrder) {
        LinkedListInt linkedList = new LinkedListInt();
        for (int value : pushBackOrder) {
            linkedList.pushFront(value);
        }
        return areEqual(reverse(pushBackOrder), linkedList);
    }

    /**
     * Checks if an int array and a LinkedListInt object are equals
     *
     * @return true if they are equal, false otherwise
     */
    boolean areEqual(int[] intArray, LinkedListInt linkedList) {
        if (intArray.length != linkedList.getSize()) {
            return false;
        }
        int[] a = linkedList.toArray();
        for (int i = 0; i < a.length; i++) {
            if (intArray[i] != a[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Reverses an array
     *
     * @param a the original array
     * @return a reversed copy of the original array
     */
    int[] reverse(int[] a) {
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            r[i] = a[a.length - i - 1];
        }
        return r;
    }
}