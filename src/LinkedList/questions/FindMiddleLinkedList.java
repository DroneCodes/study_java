package LinkedList.questions;

import LinkedList.type_declaration.ListNode;

public class FindMiddleLinkedList {

    /**
     * Finds the middle node of a singly linked list.
     *
     * @param head the head of the singly linked list
     * @return the middle node of the singly linked list
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static ListNode findMiddle(ListNode head) {
        ListNode ptr1, ptr2;
        ptr1 = ptr2 = head;
        int i = 0;
        // Keep looping until ptr1 reaches the end of the list (next would be null for the last node)
        while (ptr1.getNext() != null) {
            if (i == 0) {
                ptr1 = ptr1.getNext(); // increment only the first pointer.
                i = 1;
            } else if (i == 1) {
                // increment both pointers.
                ptr1 = ptr1.getNext();
                ptr2 = ptr2.getNext();
                i = 0;
            }
        }
        return ptr2; // return the second pointer which would be at the middle of the list.
    }
}