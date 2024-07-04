package LinkedList.leetcodeQuestions;

/**
 * Definition for singly-linked list node.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    /**
     * Constructor for ListNode.
     * @param val Value of the node.
     */
    ListNode(int val) { this.val = val; }

    /**
     * Constructor for ListNode with next node.
     * @param val Value of the node.
     * @param next Reference to the next node.
     */
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * Solution for merging nodes in a linked list separated by zeroes.
 * This class provides a method to merge nodes in a linked list where each segment between two zeroes
 * is merged into a single node representing the sum of that segment. The resulting list does not contain zeroes.
 */
public class MergeNodesInBetweenZeroes {

    /**
     * Merges nodes in a linked list separated by zeroes.
     * Each segment of nodes between two zeroes is merged into a single node with a value equal to the sum of the segment.
     * The resulting linked list does not contain any zeroes.
     *
     * @param head The head of the linked list to be processed.
     * @return The head of the modified linked list without zeroes and with nodes merged.
     */
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0); // Create a dummy node to help in forming the new list
        ListNode current = dummy; // This will be used to add new nodes to the resultant list
        int sum = 0; // To keep track of the sum between zeros

        // Start from the first node after the initial dummy 0 node
        head = head.next;

        while (head != null) {
            if (head.val != 0) {
                // If the current node is not 0, add its value to sum
                sum += head.val;
            } else {
                // If the current node is 0, it means we need to finish the current sum segment
                // Create a new node with the sum and reset sum to 0
                current.next = new ListNode(sum);
                current = current.next; // Move to the new node
                sum = 0; // Reset sum for the next segment
            }
            head = head.next; // Move to the next node in the original list
        }

        return dummy.next; // Return the head of the modified list, skipping the initial dummy node
    }
}