package com.nathanwien.plsimplement.containers.lists;

import com.nathanwien.plsimplement.containers.lists.linkedlist.LinkedListInt;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Group;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;

@Group
public class LinkedListIntTest {

    @Group
    class PushBackShould {
        @Property
        boolean maintainLinksCorrectly(@ForAll int[] pushOrder) {
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
        boolean pushBackCorrectly(@ForAll int[] pushOrder) {
            LinkedListInt linkedList = new LinkedListInt();
            for (int value : pushOrder) {
                linkedList.pushBack(value);
            }
            return areEqual(pushOrder, linkedList);
        }

        @Property
        boolean maintainSizeCorrectly(@ForAll("arbitraryLinkedListInt") LinkedListInt list,
                                      @ForAll int value) {
            int initialSize = list.getSize();
            list.pushBack(value);
            return list.getSize() == initialSize + 1;
        }
    }

    @Group
    class PushFrontShould {
        @Property
        boolean maintainLinksCorrectly(@ForAll int[] pushOrder) {
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
        boolean pushFrontCorrectly(@ForAll int[] pushOrder) {
            LinkedListInt linkedList = new LinkedListInt();
            for (int value : pushOrder) {
                linkedList.pushFront(value);
            }
            return areEqual(reverse(pushOrder), linkedList);
        }

        @Property
        boolean maintainSizeCorrectly(@ForAll("arbitraryLinkedListInt") LinkedListInt list,
                                      @ForAll int value) {
            int initialSize = list.getSize();
            list.pushFront(value);
            return list.getSize() == initialSize + 1;
        }
    }

    @Group
    class ReverseShould {
        @Property
        boolean maintainLinksCorrectly(@ForAll int[] pushBackOrder) {
            LinkedListInt linkedList = new LinkedListInt();
            for (int value : pushBackOrder) {
                linkedList.pushBack(value);
            }
            linkedList.reverse();
            return linkedList.getSize() == linkedList.getNodeCount();
        }

        @Property
        boolean reverseCorrectly(@ForAll("arbitraryLinkedListInt") LinkedListInt list) {
            int[] a = list.toArray();
            int[] ra = reverse(a);
            list.reverse();
            return areEqual(ra, list);
        }
    }

    @Group
    class GetFrontShould {
        @Property
        boolean behaveCorrectly(@ForAll("arbitraryLinkedListInt") LinkedListInt list) {
            try {
                int[] a = list.toArray();
                return list.getFront() == a[0];
            } catch (IllegalStateException e) {
                return list.getSize() == 0 && list.getNodeCount() == 0;
            } catch (Exception e) {
                return false;
            }
        }
    }

    @Group
    class GetBackShould {
        @Property
        boolean behaveCorrectly(@ForAll("arbitraryLinkedListInt") LinkedListInt list) {
            try {
                int[] a = list.toArray();
                return list.getBack() == a[a.length - 1];
            } catch (IllegalStateException e) {
                return list.getSize() == 0 && list.getNodeCount() == 0;
            } catch (Exception e) {
                return false;
            }
        }
    }

    @Group
    class PopBackShould {
        @Property
        boolean maintainSizeCorrectly(@ForAll("arbitraryLinkedListInt") LinkedListInt list) {
            try {
                int initialSize = list.getSize();
                list.popBack();
                return list.getSize() == initialSize - 1;
            } catch (IllegalStateException e) {
                return list.getSize() == 0 && list.getNodeCount() == 0;
            } catch (Exception e) {
                return false;
            }
        }

        @Property
        boolean maintainLinksCorrectly(@ForAll("arbitraryLinkedListInt") LinkedListInt list) {
            try {
                int initialNodeCount = list.getNodeCount();
                list.popBack();
                return list.getNodeCount() == initialNodeCount - 1;
            } catch (IllegalStateException e) {
                return list.getSize() == 0 && list.getNodeCount() == 0;
            } catch (Exception e) {
                return false;
            }
        }

        @Property
        boolean maintainContentCorrectly(@ForAll("arbitraryLinkedListInt") LinkedListInt list) {
            try {
                int[] a = list.toArray();
                list.popBack();
                int[] b = new int[a.length - 1];
                System.arraycopy(a, 0, b, 0, a.length - 1);
                return areEqual(b, list);
            } catch (IllegalStateException e) {
                return list.getSize() == 0 && list.getNodeCount() == 0;
            } catch (Exception e) {
                return false;
            }
        }
    }

    @Group
    class PopFrontShould {
        @Property
        boolean maintainSizeCorrectly(@ForAll("arbitraryLinkedListInt") LinkedListInt list) {
            try {
                int initialSize = list.getSize();
                list.popFront();
                return list.getSize() == initialSize - 1;
            } catch (IllegalStateException e) {
                return list.getSize() == 0 && list.getNodeCount() == 0;
            } catch (Exception e) {
                return false;
            }
        }

        @Property
        boolean maintainLinksCorrectly(@ForAll("arbitraryLinkedListInt") LinkedListInt list) {
            try {
                int initialNodeCount = list.getNodeCount();
                list.popFront();
                return list.getNodeCount() == initialNodeCount - 1;
            } catch (IllegalStateException e) {
                return list.getSize() == 0 && list.getNodeCount() == 0;
            } catch (Exception e) {
                return false;
            }
        }

        @Property
        boolean maintainContentCorrectly(@ForAll("arbitraryLinkedListInt") LinkedListInt list) {
            try {
                int[] a = list.toArray();
                list.popFront();
                int[] b = new int[a.length - 1];
                System.arraycopy(a, 1, b, 0, a.length - 1);
                return areEqual(b, list);
            } catch (IllegalStateException e) {
                return list.getSize() == 0 && list.getNodeCount() == 0;
            } catch (Exception e) {
                return false;
            }
        }
    }

    @Provide
    Arbitrary<LinkedListInt> arbitraryLinkedListInt() {
        return Arbitraries.integers().list().ofMinSize(0).ofMaxSize(10).map(arbitraryIntList -> {
            LinkedListInt linkedListInt = new LinkedListInt();
            for (int x : arbitraryIntList) {
                linkedListInt.pushBack(x);
            }
            return linkedListInt;
        });
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
        for (int i = 0; i < intArray.length; i++) {
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