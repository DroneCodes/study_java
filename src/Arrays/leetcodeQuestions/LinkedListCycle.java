package Arrays.leetcodeQuestions;

public class LinkedListCycle {
    /**
     * Determines if a linked list has a cycle.
     * @param head the head of the linked list
     * @return true if the list has a cycle, false otherwise
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
