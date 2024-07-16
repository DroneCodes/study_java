package LinkedList;

import LinkedList.type_declaration.ListNode;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;

public class UnrolledLinkedLists<E> extends AbstractList<E> implements List<E>, Serializable {
    // The maximum number of elements that can be stored in a single node
    private int nodeCapacity;
    //The current size of this List
    private int size = 0;
    // The first node of this list
    private ListNode firstNode;
    // The last node of this list
    private ListNode lastNode;

}
