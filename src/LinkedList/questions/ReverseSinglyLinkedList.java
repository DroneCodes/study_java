package LinkedList.questions;

import LinkedList.type_declaration.ListNode;

/**
 * This class provides a method to reverse a singly linked list.
 */
public class ReverseSinglyLinkedList {

    /**
     * Reverses the given singly linked list.
     *
     * @param head the head of the singly linked list to be reversed
     * @return the new head of the reversed singly linked list
     * @implNote The time complexity of this method is O(n), where n is the number of nodes in the list.
     * The space complexity is O(1).
     */
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null; // Previous node, initially null
        ListNode current = head; // Current node, starting with the head
        while (current != null) {
            ListNode next = current.getNext(); // Store the next node
            current.setNext(prev); // Reverse the current node's pointer
            prev = current; // Move the previous node to the current node
            current = next; // Move to the next node in the list
        }
        return prev; // New head of the reversed list
    }

    /**
     * Reverses the given singly linked list using recursion.
     *
     * @param current the current node in the singly linked list
     * @param head    an array to store the new head of the reversed singly linked list
     *
     * @implNote The time complexity of this method is O(n), where n is the number of nodes in the list.
     * The space complexity is O(n) due to the recursive calls.
     */
    public static void reverseListReverse(ListNode current, ListNode[] head) {
        if (current == null) {
            return;
        }
        ListNode next = current.getNext();
        if (next == null) {
            head[0] = current;
            return;
        }
        reverseListReverse(next, head);
        // Make next node points to current node
        next.setNext(current);
        // Remove the link between current node and next node
        current.setNext(null);
    }
}