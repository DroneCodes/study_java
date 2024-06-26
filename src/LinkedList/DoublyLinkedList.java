package LinkedList;

import LinkedList.type_declaration.DoublyListNode;

/**
 * This class represents a DoublyLinkedList.
 * Each DoublyLinkedList has a head and a tail node, and an integer to keep track of its length.
 */
public class DoublyLinkedList {

    // The head node of the DoublyLinkedList.
    private DoublyListNode head;

    // The tail node of the DoublyLinkedList.
    private DoublyListNode tail;

    // The length of the DoublyLinkedList.
    private int length;

    /**
     * Constructor that initializes an empty DoublyLinkedList.
     * The head and tail nodes are dummy nodes (sentinels) which do not hold any data.
     */
    public DoublyLinkedList() {
        head = new DoublyListNode(Integer.MIN_VALUE, null, null);
        tail = new DoublyListNode(Integer.MIN_VALUE, head, null);
        head.setNext(tail);
        length = 0;
    }

    /**
     * Returns the value at a given position in the DoublyLinkedList.
     * @param position The position of the value to be returned.
     * @return The value at the given position. Returns Integer.MIN_VALUE if the position is invalid.
     */
    public int get(int position) {
        return Integer.MIN_VALUE;
    }

    /**
     * Returns the position of the first occurrence of a given value in the DoublyLinkedList.
     * @param data The value to be searched in the DoublyLinkedList.
     * @return The position of the first occurrence of the value. Returns Integer.MIN_VALUE if the value is not found.
     */
    public int getPosition(int data) {
        // Go looking for the data
        DoublyListNode temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.getData() == data) {
                // Return the position if found
                return pos;
            }
            pos++;
            temp = temp.getNext();
        }
        // Else return some large value
        return Integer.MIN_VALUE;
    }

    /**
     * Returns the current length of the DoublyLinkedList.
     * @return The length of the DoublyLinkedList.
     */
    public int length() {
        return length;
    }

    /**
     * Inserts a new value at the head of the DoublyLinkedList.
     * @param newValue The value to be inserted.
     */
    public void insertAtHead(int newValue) {
        DoublyListNode newNode = new DoublyListNode(newValue, null, head.getNext());
        newNode.getNext().setPrev(newNode);
        head = newNode;
        length++;
    }

    /**
     * Inserts a new value at a given position in the DoublyLinkedList.
     * All values at that position or greater have their position increased by 1.
     * @param data The value to be inserted.
     * @param position The position at which the value should be inserted.
     */
    public void insert(int data, int position) {
        // Fix the position
        if (position < 0) {
            position = 0;
        }
        if (position > length) {
            position = length;
        }

        // If the list is empty, make it be the only element
        if (head == null) {
            head = new DoublyListNode(data);
            tail = head;
        }
        // If adding at the front of the list
        else if (position == 0) {
            DoublyListNode temp = new DoublyListNode(data);
            temp.next = head;
            head = temp;
        }
        // Else find the correct position and insert
        else {
            DoublyListNode temp = head;
            for (int i = 1; i < position; i++) {
                temp = temp.getNext();
            }
            DoublyListNode newNode = new DoublyListNode(data);
            newNode.next = temp.next;
            newNode.prev = temp;
            newNode.next.prev = newNode;
            temp.next = newNode;
        }
        // The list is now one value longer
        length++;
    }

    /**
     * Inserts a new value at the end of the DoublyLinkedList.
     * @param newValue The value to be inserted.
     */
    public void insertAtEnd(int newValue) {
        DoublyListNode newNode = new DoublyListNode(newValue, tail.getPrev(), tail);
        newNode.getPrev().setNext(newNode);
        tail.setPrev(newNode);
        length++;
    }

    /**
     * Removes the value at a given position in the DoublyLinkedList.
     * If the position is less than 0, removes the value at position 0.
     * If the position is greater than 0, removes the value at the last position.
     * @param position The position of the value to be removed.
     */
    public void remove(int position) {
        // Fix the position
        if (position < 0) {
            position = 0;
        }
        if (position >= length) {
            position = length - 1;
        }

        // If nothing in the list, do nothing
        if (head == null) {
            return;
        }

        // If removing the head element
        if (position == 0) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        }
        // Else advance to the correct position and remove
        else {
            DoublyListNode temp = head;
            for (int i = 1; i < position; i++) {
                temp = temp.getNext();
            }
            temp.getNext().setPrev(temp.getPrev());
            temp.getPrev().setNext(temp.getNext());
        }
        // Reduce the length of the list
        length--;
    }

    /**
     * Removes a node matching the specified node from the DoublyLinkedList.
     * @param node The node to be removed.
     */
    public synchronized void removeMatched(DoublyListNode node) {
        if (head == null) {
            return;
        }
        if (node.equals(head)) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            return;
        }
        DoublyListNode p = head;
        while (p != null) {
            if (node.equals(p)) {
                p.prev.next = p.next;
                p.next.prev = p.prev;
                return;
            }
        }
    }

    /**
     * Removes the head value from the DoublyLinkedList.
     * If the list is empty, does nothing.
     * @return The value that was removed. Returns Integer.MIN_VALUE if the list is empty.
     */
    public int removeHead() {
        if (length == 0) {
            return Integer.MIN_VALUE;
        }
        DoublyListNode save = head.getNext();
        head.setNext(save.getNext());
        save.getNext().setPrev(head);
        length--;
        return save.getData();
    }

    /**
     * Removes the last value from the DoublyLinkedList.
     * If the list is empty, does nothing.
     * @return The value that was removed. Returns Integer.MIN_VALUE if the list is empty.
     */
    public int removeEnd() {
        if (length == 0) {
            return Integer.MIN_VALUE;
        }
        DoublyListNode save = tail.getPrev();
        tail.setPrev(save.getPrev());
        save.getPrev().setNext(tail);
        length--;
        return save.getData();
    }

    /**
     * Returns a string representation of the DoublyLinkedList, in the form ["str1","str2",...].
     * @return A string representation of the DoublyLinkedList.
     */
    public String toString() {
        String result = "[";
        if (length == 0) {
            return result;
        }
        result = "[" + head.getNext().getData();
        DoublyListNode temp = head.getNext().getNext();
        while (temp != tail) {
            result = result + "," + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }

    /**
     * Removes all elements from the DoublyLinkedList.
     */
    public void clearList() {
        head = null;
        tail = null;
        length = 0;
    }
}