package LinkedList.type_declaration;

/**
 * This class represents a node in a circular linked list.
 * Each node has a data field and a pointer to the next node.
 * In a circular linked list, the last node points back to the first node.
 */
public class CircularListNode {

    // The data stored in this node.
    public int data;

    // The next node in the linked list.
    public CircularListNode next;

    /**
     * Constructor that initializes the node with a given data and sets next to null.
     * @param data The data to be stored in the node.
     */
    public CircularListNode(int data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Constructor that initializes the node with a given data and next node.
     * @param data The data to be stored in the node.
     * @param next The next node in the linked list.
     */
    public CircularListNode(int data, CircularListNode next) {
        this.data = data;
        this.next = next;
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
    public CircularListNode getNext() {
        return next;
    }

    /**
     * Sets the next node in the linked list.
     * @param next The node to be set as the next node.
     */
    public void setNext(CircularListNode next) {
        this.next = next;
    }
}