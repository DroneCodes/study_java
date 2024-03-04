package Arrays.leetcodeQuestions;


/**
 * Solution class for removing the nth node from the end of a linked list.
 */

public class RemoventhFromEnd {
    /**
     * Removes the nth node from the end of a linked list.
     * @param head the head of the linked list
     * @param n the position from the end of the list of the node to remove
     * @return the head of the modified list
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
