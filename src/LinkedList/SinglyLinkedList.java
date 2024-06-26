package LinkedList;

import LinkedList.type_declaration.ListNode;

/**
 * This class represents a singly linked list.
 */
public class SinglyLinkedList {

    // This class has a default constructor that initializes the length of the linked list to 0.
    /**
     * Default constructor that initializes the length of the linked list to 0.
     */
    public SinglyLinkedList() {
        length = 0;
    }

    // This is the only field of the class. It holds the head of the linked list.
    /**
     * The head of the linked list.
     */
    ListNode head;

    // Length of the linked list
    /**
     * The length of the linked list.
     */
    private int length = 0;

    // Return the first node in the linked list
    /**
     * Returns the first node in the linked list.
     * @return The head of the linked list.
     */
    public synchronized ListNode getHead() {
        return head;
    }

    // Insert a node at the beginning of the linked list
    /**
     * Inserts a node at the beginning of the linked list.
     * @param node The node to be inserted.
     */
    public synchronized void insertAtBegin(ListNode node) {
        node.setNext(head);
        head = node;
        length++;
    }

    // Insert a node at the end of the linked list
    /**
     * Inserts a node at the end of the linked list.
     * @param node The node to be inserted.
     */
    public synchronized void insertAtEnd(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode p, q;
            for (p = head; (q = p.getNext()) != null; p = q) ;
            p.setNext(node);
        }
        length++;
    }

    // Add a new value to the list at a given position
    // All values at that position or greater have their position increased by 1. They move over to make room for the new element.
    /**
     * Inserts a new value at a given position in the list.
     * All values at that position or greater have their position increased by 1.
     * @param data The value to be inserted.
     * @param position The position at which the value should be inserted.
     */
    public void insert(int data, int position) {
        // fix the position
        if (position < 0) {
            position = 0;
        }
        if (position > length) {
            position = length;
        }

        // if the list is empty, make it be the only element
        if (head == null) {
            head = new ListNode(data);
        }

        // if adding at the front of the list
        else if (position == 0) {
            ListNode temp = new ListNode(data);
            temp.next = head;
            head = temp;
        }

        // else find the correct position and insert
        else {
            ListNode temp = head;
            for (int i = 1; i < position; i++) {
                temp = temp.next;
            }
            ListNode newNode = new ListNode(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }
        // the list is now one value longer
        length++;
    }

    // Remove and return the node at the head of the linked list
    /**
     * Removes and returns the node at the head of the linked list.
     * @return The node that was removed.
     */
    public synchronized ListNode deleteAtBegin() {
        ListNode node = head;
        if (node != null) {
            head = node.getNext();
            node.setNext(null);
        }
        return node;
    }

    // Remove and return the node at the end of the linked list
    /**
     * Removes and returns the node at the end of the linked list.
     * @return The node that was removed.
     */
    public synchronized ListNode deleteAtEnd() {
        if (head == null) {
            return null;
        }
        ListNode p = head, q = null, next = head.getNext();
        if (next == null) {
            head = null;
            return p;
        }
        while ((next = p.getNext()) != null) {
            q = p;
            p = next;
        }
        q.setNext(null);
        return p;
    }

    // Remove a node matching the specified node from the list. Use equals() instead of == to test for a matched node.
    /**
     * Removes a node matching the specified node from the list.
     * @param node The node to be removed.
     */
    public synchronized void deleteNode(ListNode node) {
        if (head == null) {
            return;
        }
        if (node.equals(head)) {
            head = head.getNext();
            return;
        }
        ListNode p = head, q = null;
        while ((q = p.getNext()) != null) {
            if (node.equals(q)) {
                p.setNext(q.getNext());
                return;
            }
            p = q;
        }
    }

    // Remove the value at a given position
    // If the position is less than 0, remove the value at position 0.
    // If the position is greater than 0, remove the value at the last position.
    /**
     * Removes the value at a given position.
     * If the position is less than 0, removes the value at position 0.
     * If the position is greater than 0, removes the value at the last position.
     * @param position The position of the value to be removed.
     */
    public void delete(int position) {
        // fix position
        if (position < 0) {
            position = 0;
        }
        if (position >= length) {
            position = length - 1;
        }

        // if nothing in the list, do nothing
        if (head == null) {
            return;
        }

        // if removing the head element
        if (position == 0) {
            head = head.next;
        }

        // else advance to the correct position and remove
        else {
            ListNode temp = head;
            for (int i = 1; i < position; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        // list is one element shorter
        length--;
    }

    // Return a string representation of this collection, in the form ["str1", "str2", ...].
    /**
     * Returns a string representation of this collection, in the form ["str1", "str2", ...].
     * @return A string representation of the linked list.
     */
    public String toString() {
        String result = "[";
        if (head == null) {
            return result + "]";
        }
        result = result + head.getData();
        ListNode temp = head.getNext();

        while (temp != null) {
            result = result + ", " + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }

    // Return the current length of the linked list.
    /**
     * Returns the current length of the linked list.
     * @return The length of the linked list.
     */
    public int length() {
        return length;
    }

    // Find the position of the first value that is equal to a given value.
    // The equals method us used to determine equality.
    /**
     * Finds the position of the first value that is equal to a given value.
     * The equals method is used to determine equality.
     * @param data The value to find.
     * @return The position of the value in the list, or Integer.MIN_VALUE if the value is not found.
     */
    public int getPosition(int data) {
        // go looking for the data
        ListNode temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.getData() == data) {
                // return the position if found
                return pos;
            }
            pos++;
            temp = temp.getNext();
        }
        // else return some large value
        return Integer.MIN_VALUE;
    }

    // Remove everything from the linked list.
    /**
     * Removes everything from the linked list.
     */
    public void clearList() {
        head = null;
        length = 0;
    }

}