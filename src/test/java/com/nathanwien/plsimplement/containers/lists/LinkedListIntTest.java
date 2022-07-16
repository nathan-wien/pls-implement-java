package com.nathanwien.plsimplement.containers.lists;

import com.nathanwien.plsimplement.containers.lists.linkedlist.LinkedListInt;
import net.jqwik.api.Disabled;
import net.jqwik.api.ForAll;
import net.jqwik.api.Group;
import net.jqwik.api.Property;

public class LinkedListIntTest {

    @Group
    @Disabled
    class PushBackShould {
        @Property
        boolean maintainLinksProperly(@ForAll int[] pushOrder) {
            LinkedListInt linkedList = new LinkedListInt();
            for (int value : pushOrder) {
                linkedList.pushBack(value);
                if (linkedList.getSize() != linkedList.getNodeCount()) {
                    return false;
                }
            }
            return true;
        }

        @Property
        boolean pushBackProperly(@ForAll int[] pushOrder) {
            LinkedListInt linkedList = new LinkedListInt();
            for (int value : pushOrder) {
                linkedList.pushBack(value);
            }
            return areEqual(pushOrder, linkedList);
        }
    }

    @Group
    @Disabled
    class PushFrontShould {
        @Property
        boolean maintainLinksProperly(@ForAll int[] pushOrder) {
            LinkedListInt linkedList = new LinkedListInt();
            for (int value : pushOrder) {
                linkedList.pushFront(value);
                if (linkedList.getSize() != linkedList.getNodeCount()) {
                    return false;
                }
            }
            return true;
        }

        @Property
        boolean pushFrontProperly(@ForAll int[] pushOrder) {
            LinkedListInt linkedList = new LinkedListInt();
            for (int value : pushOrder) {
                linkedList.pushFront(value);
            }
            return areEqual(reverse(pushOrder), linkedList);
        }
    }

    @Group
    @Disabled
    class ReverseShould {
        @Property
        boolean maintainLinksProperly(@ForAll int[] pushBackOrder) {
            LinkedListInt linkedList = new LinkedListInt();
            for (int value : pushBackOrder) {
                linkedList.pushBack(value);
            }
            linkedList.reverse();
            return linkedList.getSize() == linkedList.getNodeCount();
        }

        @Property
        boolean reverseCorrectly(@ForAll int[] pushFrontOrder) {
            LinkedListInt linkedList = new LinkedListInt();
            for (int value : pushFrontOrder) {
                linkedList.pushFront(value);
            }
            linkedList.reverse();
            return areEqual(pushFrontOrder, linkedList);
        }
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