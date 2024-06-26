package LinkedList.type_declaration;

/**
 * This class represents a node in a singly linked list.
 * Each node has an integer value and a reference to the next node in the list.
 */
public class ListNode {

    private int data;  // The integer value stored in this node
    public ListNode next;  // Reference to the next node in the list

    /**
     * Constructs a new ListNode with the given data and a null next node reference.
     *
     * @param data The integer value to be stored in this node.
     */
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Returns the integer value stored in this node.
     *
     * @return The integer value stored in this node.
     */
    public int getData() {
        return this.data;
    }

    /**
     * Sets the integer value stored in this node.
     *
     * @param data The integer value to be stored in this node.
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * Returns the next node this node points to.
     *
     * @return The next ListNode this node points to, or null if there is no next node.
     */
    public ListNode getNext() {
        return this.next;
    }

    /**
     * Sets the next node this node should point to.
     *
     * @param next The ListNode that should follow this one in the list.
     */
    public void setNext(ListNode next) {
        this.next = next;
    }
}