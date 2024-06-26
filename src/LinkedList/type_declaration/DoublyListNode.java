package LinkedList.type_declaration;

/**
 * This class represents a node in a doubly linked list.
 * Each node has a data field and two pointers, one to the next node and one to the previous node.
 */
public class DoublyListNode {

    // The data stored in this node.
    public int data;

    // The next node in the linked list.
    public DoublyListNode next;

    // The previous node in the linked list.
    public DoublyListNode prev;

    /**
     * Constructor that initializes the node with a given data and sets next and prev to null.
     * @param data The data to be stored in the node.
     */
    public DoublyListNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    /**
     * Constructor that initializes the node with a given data, next node, and previous node.
     * @param data The data to be stored in the node.
     * @param next The next node in the linked list.
     * @param prev The previous node in the linked list.
     */
    public DoublyListNode(int data, DoublyListNode next, DoublyListNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    /**
     * Returns the data stored in this node.
     * @return The data stored in this node.
     */
    public int getData() {
        return data;
    }

    /**
     * Sets the data stored in this node.
     * @param data The data to be stored in this node.
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * Returns the next node in the linked list.
     * @return The next node in the linked list.
     */
    public DoublyListNode getNext() {
        return next;
    }

    /**
     * Sets the next node in the linked list.
     * @param next The node to be set as the next node.
     */
    public void setNext(DoublyListNode next) {
        this.next = next;
    }

    /**
     * Returns the previous node in the linked list.
     * @return The previous node in the linked list.
     */
    public DoublyListNode getPrev() {
        return prev;
    }

    /**
     * Sets the previous node in the linked list.
     * @param prev The node to be set as the previous node.
     */
    public void setPrev(DoublyListNode prev) {
        this.prev = prev;
    }
}