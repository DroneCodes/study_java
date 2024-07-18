package LinkedList;

import LinkedList.type_declaration.ListNode;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

public class UnrolledLinkedList<E> extends AbstractList<E> implements List<E>, Serializable {
    // The maximum number of elements that can be stored in a single node
    private int nodeCapacity;

    //The current size of this List
    private int size = 0;

    // The first node of this list
    private ListNode firstNode;

    // The last node of this list
    private ListNode lastNode;

    // Constructs an empty list with the specified capacity
    public UnrolledLinkedList(int nodeCapacity) throws IllegalArgumentException {
        if (nodeCapacity < 8) {
            throw new IllegalArgumentException("nodeCapacity < 8");
        }
        this.nodeCapacity = nodeCapacity;
        firstNode= new ListNode(nodeCapacity);
        lastNode = firstNode;
    }

    public UnrolledLinkedList() {
        this(16);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    // Returns true if this list contains the specified element
    public boolean contains(Object obj) {
        return (indexOf(obj) != -1);
    }

    public Iterator<E> iterator() {
        return new ULLIterator();
    }
}
