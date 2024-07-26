package LinkedList;

import LinkedList.type_declaration.ListNode;

import java.io.Serializable;
import java.util.*;

/**
 * Represents an unrolled linked list, a type of list that stores elements in nodes with a fixed capacity.
 * This class extends AbstractList and implements List and Serializable interfaces.
 *
 * @param <E> the type of elements in this list
 */
public class UnrolledLinkedList<E> extends AbstractList<E> implements List<E>, Serializable {
    // The maximum number of elements that can be stored in a single node
    private int nodeCapacity;

    // The current size of this List
    private int size = 0;

    // The first node of this list
    private ListNode firstNode;

    // The last node of this list
    private ListNode lastNode;

    /**
     * Constructs an empty list with the specified capacity.
     *
     * @param nodeCapacity the maximum number of elements that can be stored in a single node
     * @throws IllegalArgumentException if the nodeCapacity is less than 8
     */
    public UnrolledLinkedList(int nodeCapacity) throws IllegalArgumentException {
        if (nodeCapacity < 8) {
            throw new IllegalArgumentException("nodeCapacity < 8");
        }
        this.nodeCapacity = nodeCapacity;
        firstNode = new ListNode();
        lastNode = firstNode;
    }

    /**
     * Constructs an empty list with a default capacity of 16.
     */
    public UnrolledLinkedList() {
        this(16);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param obj element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    public boolean contains(Object obj) {
        return (indexOf(obj) != -1);
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    public Iterator<E> iterator() {
        return new ULLIterator(firstNode, 0, 0);
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param obj element to be appended to this list
     * @return true (as specified by Collection.add(E))
     */
    public boolean add(E obj) {
        insertIntoNode(lastNode, lastNode.numElements, obj);
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param obj element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    public boolean remove(Object obj) {
        int index = 0;
        ListNode node = firstNode;
        if (obj == null) {
            while (node != null) {
                for (int i = 0; i < node.numElements; i++) {
                    if (node.elements[i] == null) {
                        removeFromNode(node, i);
                        return true;
                    }
                }
                index += node.numElements;
                node = node.next;
            }
        } else {
            while (node != null) {
                for (int i = 0; i < node.numElements; i++) {
                    if (obj.equals(node.elements[i])) {
                        removeFromNode(node, i);
                        return true;
                    }
                }
                index += node.numElements;
                node = node.next;
            }
        }
        return false;
    }

    /**
     * Removes all the elements from this list.
     * The list will be empty after this call returns.
     */
    public void clear() {
        ListNode node = firstNode.next;
        while (node != null) {
            ListNode next = node.next;
            node.next = null;
            node.previous = null;
            node.elements = null;
            node = next;
        }
        lastNode = firstNode;
        for (int i = 0; i < firstNode.numElements; i++) {
            firstNode.elements[i] = null;
        }
        firstNode.numElements = 0;
        firstNode.next = null;
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode node;
        int p = 0;
        if (size - index > index) {
            node = firstNode;
            while (p <= index - node.numElements) {
                p += node.numElements;
                node = node.next;
            }
        } else {
            node = lastNode;
            p = size;
            while ((p -= node.numElements) > index) {
                node = node.previous;
            }
        }
        return (E) node.elements[index - p];
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E obj = null;
        ListNode node;
        int p = 0;
        if (size - index > index) {
            node = firstNode;
            while (p <= index - node.numElements) {
                p += node.numElements;
                node = node.next;
            }
        } else {
            node = lastNode;
            p = size;
            while ((p -= node.numElements) > index) {
                node = node.previous;
            }
        }
        obj = (E) node.elements[index - p];
        node.elements[index - p] = element;
        return obj;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     */
    public void add(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode node;
        int p = 0;
        if (size - index > index) {
            node = firstNode;
            while (p <= index - node.numElements) {
                p += node.numElements;
                node = node.next;
            }
        } else {
            node = lastNode;
            p = size;
            while ((p -= node.numElements) > index) {
                node = node.previous;
            }
        }
        insertIntoNode(node, index - p, element);
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E obj = null;
        ListNode node;
        int p = 0;
        if (size - index > index) {
            node = firstNode;
            while (p <= index - node.numElements) {
                p += node.numElements;
                node = node.next;
            }
        } else {
            node = lastNode;
            p = size;
            while ((p -= node.numElements) > index) {
                node = node.previous;
            }
        }
        obj = (E) node.elements[index - p];
        removeFromNode(node, index - p);
        return obj;
    }

    private static final long serialVersionUID = -674052309103045211L;

    /**
     * Represents a node in the unrolled linked list.
     */
    private class ListNode {
        ListNode next;
        ListNode previous;
        int numElements = 0;
        Object[] elements;

        /**
         * Constructs a ListNode with the specified capacity.
         */
        ListNode() {
            elements = new Object[nodeCapacity];
        }
    }

    /**
     * An iterator over the elements in this list in proper sequence.
     */
    private class ULLIterator implements ListIterator<E> {
        UnrolledLinkedList.ListNode currentNode;
        int ptr;
        int index;
        private int expectedModCount = modCount;

        /**
         * Constructs an iterator starting at the specified node, pointer, and index.
         *
         * @param node the starting node
         * @param ptr the starting pointer
         * @param index the starting index
         */
        ULLIterator(UnrolledLinkedList.ListNode node, int ptr, int index) {
            this.currentNode = node;
            this.ptr = ptr;
            this.index = index;
        }

        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements
         */
        public boolean hasNext() {
            return (index < size - 1);
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        public E next() {
            ptr++;
            if (ptr >= currentNode.numElements) {
                if (currentNode.next != null) {
                    currentNode = currentNode.next;
                    ptr = 0;
                } else {
                    throw new NoSuchElementException();
                }
            }
            index++;
            checkForModification();
            return (E) currentNode.elements[ptr];
        }

        /**
         * Returns true if the iteration has more elements when traversing the list in the reverse direction.
         *
         * @return true if the iteration has more elements when traversing the list in the reverse direction
         */
        public boolean hasPrevious() {
            return (index > 0);
        }

        /**
         * Returns the previous element in the iteration.
         *
         * @return the previous element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements when traversing the list in the reverse direction
         */
        public E previous() {
            ptr--;
            if (ptr < 0) {
                if (currentNode.previous != null) {
                    currentNode = currentNode.previous;
                    ptr = currentNode.numElements - 1;
                } else {
                    throw new NoSuchElementException();
                }
            }
            index--;
            checkForModification();
            return (E) currentNode.elements[ptr];
        }

        /**
         * Returns the index of the element that would be returned by a subsequent call to next().
         *
         * @return the index of the element that would be returned by a subsequent call to next()
         */
        public int nextIndex() {
            return index + 1;
        }

        /**
         * Returns the index of the element that would be returned by a subsequent call to previous().
         *
         * @return the index of the element that would be returned by a subsequent call to previous()
         */
        public int previousIndex() {
            return index - 1;
        }

        /**
         * Removes from the list the last element that was returned by next() or previous().
         *
         * @throws IllegalStateException if neither next() nor previous() have been called, or remove() or add(E) have been called after the last call to next() or previous()
         */
        public void remove() {
            checkForModification();
            removeFromNode(currentNode, ptr);
        }

        /**
         * Replaces the last element returned by next() or previous() with the specified element.
         *
         * @param obj the element with which to replace the last element returned by next() or previous()
         * @throws IllegalStateException if neither next() nor previous() have been called, or remove() or add(E) have been called after the last call to next() or previous()
         */
        public void set(E obj) {
            checkForModification();
            currentNode.elements[ptr] = obj;
        }

        /**
         * Inserts the specified element into the list (optional operation).
         *
         * @param obj the element to insert
         * @throws IllegalStateException if neither next() nor previous() have been called, or remove() or add(E) have been called after the last call to next() or previous()
         */
        public void add(E obj) {
            checkForModification();
            insertIntoNode(currentNode, ptr + 1, obj);
        }

        /**
         * Checks for concurrent modification.
         *
         * @throws ConcurrentModificationException if the list was modified concurrently
         */
        private void checkForModification() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * Inserts the specified element into the specified node at the specified position.
     *
     * @param node the node into which the element is to be inserted
     * @param ptr the position at which the element is to be inserted
     * @param element the element to be inserted
     */
    private void insertIntoNode(ListNode node, int ptr, E element) {
        // If the node is full
        if (node.numElements == nodeCapacity) {
            // Create a new node
            ListNode newNode = new ListNode();
            // Move half of the elements from the full node to the new node
            int elementsToMove = nodeCapacity / 2;
            int startIndex = nodeCapacity - elementsToMove;
            for (int i = 0; i < elementsToMove; i++) {
                newNode.elements[i] = node.elements[startIndex + i];
                node.elements[startIndex + i] = null;
            }
            node.numElements -= elementsToMove;
            newNode.numElements = elementsToMove;
            // Insert the new node into the list
            newNode.next = node.next;
            newNode.previous = node;
            if (node.next != null) {
                node.next.previous = newNode;
            }
            node.next = newNode;
            if (node == lastNode) {
                lastNode = newNode;
            }
            // Check whether the new element should be inserted into the original node or the new node
            if (ptr > node.numElements) {
                node = newNode;
                ptr -= node.numElements;
            }
        }
        // Shift elements to the right to make room for the new element
        for (int i = node.numElements; i > ptr; i--) {
            node.elements[i] = node.elements[i - 1];
        }
        node.elements[ptr] = element;
        node.numElements++;
        size++;
        modCount++;
    }

    /**
     * Removes the element at the specified position from the specified node.
     *
     * @param node the node from which the element is to be removed
     * @param ptr the position of the element to be removed
     */
    private void removeFromNode(ListNode node, int ptr) {
        node.numElements--;
        for (int i = ptr; i < node.numElements; i++) {
            node.elements[i] = node.elements[i + 1];
        }
        node.elements[node.numElements] = null;
        if (node.next != null && node.next.numElements + node.numElements <= nodeCapacity) {
            mergeWithNextNode(node);
        } else if (node.previous != null && node.previous.numElements + node.numElements <= nodeCapacity) {
            mergeWithNextNode(node.previous);
        }
        size--;
        modCount++;
    }

    /**
     * Merges the specified node with its next node.
     *
     * @param node the node to be merged with its next node
     */
    private void mergeWithNextNode(ListNode node) {
        ListNode next = node.next;
        for (int i = 0; i < next.numElements; i++) {
            node.elements[node.numElements + i] = next.elements[i];
            next.elements[i] = null;
        }
        node.numElements += next.numElements;
        if (next.next != null) {
            next.next.previous = node;
        }
        node.next = next.next.next;
        if (next == lastNode) {
            lastNode = node;
        }
    }
}