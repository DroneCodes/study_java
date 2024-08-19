package LinkedList.questions;

import LinkedList.type_declaration.ListNode;

public class CheckEvenOrOdd {

    /**
     * Checks if the length of the singly linked list is even or odd.
     *
     * @param listHead the head of the singly linked list
     * @return 0 if the length is even, 1 if the length is odd
     *
     * Time Complexity: O([n/2]) = O(N) where N is the number of nodes in the linked list
     * Space Complexity: O(1)
     */
    public int isLinkedListLengthEven(ListNode listHead) {
        while (listHead != null && listHead.getNext() != null) {
            listHead = listHead.getNext().getNext();
        }
        if (listHead == null) {
            return 0;
        }
        return 1;
    }
}