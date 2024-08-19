package LinkedList.questions;

import LinkedList.type_declaration.ListNode;

public class DisplayListFromEnd {
    /**
     * Prints the elements of a singly linked list from end to start.
     *
     * @param head the head of the singly linked list
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) -> for recursive stack
     */
    public static void printListFromEnd(ListNode head) {
        if (head == null) {
            return;
        }
        printListFromEnd(head.getNext());
        System.out.print(head.getData() + " ");
    }
}
