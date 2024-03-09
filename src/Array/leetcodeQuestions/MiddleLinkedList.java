package Array.leetcodeQuestions;

/**
 * The MiddleLinkedList class provides a method to find the middle node of a singly linked list.
 */
public class MiddleLinkedList {

    /**
     * This method finds the middle node of a singly linked list.
     * If there are two middle nodes, it returns the second middle node.
     *
     * @param head The head node of the linked list.
     * @return The middle node of the linked list.
     */
    public ListNode middleNode(ListNode head) {
        // Initialize two pointers, slow and fast, at the head of the list.
        ListNode slow = head;
        ListNode fast = head;

        // Move the slow pointer one step at a time and the fast pointer two steps at a time.
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // When the fast pointer reaches the end of the list, the slow pointer will be at the middle of the list.
        return slow;
    }
}