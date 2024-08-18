package LinkedList.questions;

import LinkedList.type_declaration.ListNode;

public class LengthOfTheLoop {

    /**
     * Finds the length of the loop in a linked list, if a loop exists.
     *
     * @param head the head node of the linked list
     * @return the length of the loop, or 0 if no loop exists
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public static int findLengthOfTheLoop(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        boolean isLoop = false; // check if loop exists

        // Detect if a loop exists using Floyd's Cycle-Finding Algorithm
        while (fastPointer != null && fastPointer.getNext() != null) {
            fastPointer = fastPointer.getNext().getNext();
            slowPointer = slowPointer.getNext();
            if (slowPointer == fastPointer) {
                isLoop = true;
                break;
            }
        }

        int length = 0;
        // If a loop is detected, calculate its length
        if (isLoop) {
            do {
                slowPointer = slowPointer.getNext();
                length++;
            } while (slowPointer != fastPointer);
        }

        return length;
    }


}
