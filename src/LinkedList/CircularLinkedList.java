package LinkedList;

import LinkedList.type_declaration.CircularListNode;

public class CircularLinkedList {

    protected CircularListNode tail;
    protected int length;

    public CircularLinkedList() {
        tail = null;
        length = 0;
    }

    // Adding a node to the beginning of the Circular Linked List
    public void add(int data) {
        addToHead(data);
    }

    // Adds element to head of list
    public void addToHead(int data) {
        CircularListNode temp = new CircularListNode(data);
        if (tail == null) { // first data added
            tail = temp;
            tail.setNext(tail);
        } else { // element exists in the list
            temp.setNext(tail.getNext());
            tail.setNext(temp);
        }
        length++;
    }

    // Adding a node to the end of the Circular Linked List
    public void addToTail(int data) {
        addToHead(data);
        tail = tail.getNext();
    }

    // Returns data at head of list
    public int peek() {
        return tail.getNext().getData();
    }

    // Returns data at tail of list
    public int tailPeek() {
        return tail.getData();
    }

    // Returns and removes data at head of list
    public int removeFromHead() {
        CircularListNode temp = tail.getNext(); // the head of the list
        if (tail == tail.getNext()) {
            tail = null;
        } else {
            tail.setNext(temp.getNext());
            temp.setNext(null); // helps cleans things up; temp is free
        }
        length--;
        return temp.getData();
    }

    // Returns and removes data at tail of list
    public int removeFromTail() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        CircularListNode finger = tail;
        while (finger.getNext() != tail) {
            finger = finger.getNext();
        }
        // finger now points to the one before tail
        CircularListNode temp = tail;
        if (finger == tail) {
            tail = null;
        } else {
            finger.setNext(tail.getNext());
            tail = finger;
        }
        length--;
        return temp.getData();
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return tail == null;
    }

    // Returns true if list contains data, else false
    public boolean contains(int data) {
        if (tail == null) {
            return false;
        }
        CircularListNode finger = tail.getNext();
        while (finger != tail && (!(finger.getData() == data))) {
            finger = finger.getNext();
        }
        return finger.getData() == data;
    }

    // Removes and return elements equal to data, or null if not found
    public int remove(int data) {
        if (tail == null) {
            return Integer.MIN_VALUE;
        }
        CircularListNode finger = tail.getNext();
        CircularListNode previous = tail;
        int compares;
        for (compares = 0; compares < length && (!(finger.getData() == data)); compares++) {
            previous = finger;
            finger = finger.getNext();
        }
        if (finger.getData() == data) {
            // an example of the pigeonhole principle
            if (tail == tail.getNext()) {
                tail = null;
            } else {
                if (finger == tail) {
                    tail = previous;
                }
                previous.setNext(finger.getNext());
            }
            // finger data is free
            finger.setNext(null); // to keep things disconnected
            length--;
            return finger.getData();
        }
        return Integer.MIN_VALUE;
    }

    // Return the current length and Size of the Circular Linked List
    public int size() {
        return length;
    }

    // Remove everything from the Circular Linked List
    public void clear() {
        length = 0;
        tail = null;
    }

    // Return a string representation of this collection, in the form: ["str1","str2",...]
    public String toString() {
        String result = "[";
        if (tail == null) {
            return result + "]";
        }
        result = result + tail.getData();
        CircularListNode temp = tail.getNext();
        while (temp != tail) {
            result = result + "," + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }

    // Counting nodes in a Circular Linked List

    public int countNodes(CircularListNode head) {
        int length = 0;
        CircularListNode current = head.getNext();
        while (current != head) {
            length++;
            current = current.getNext();
        }
        return length;
    }

    // Printing the contents of a Circular Linked List

    public void printList(CircularListNode head) {
        CircularListNode current = head.getNext();
        while (current != head) {
            System.out.print(current.getData() + "->");
            current = current.getNext();
        }
        System.out.println("(" + current.getData() + ")head");

    }
}
