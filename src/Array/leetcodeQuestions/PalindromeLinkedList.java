package Array.leetcodeQuestions;

/**
 * This class provides a method to check if a given singly linked list is a palindrome.
 */
public class PalindromeLinkedList {

    /**
     * This method checks if a given singly linked list is a palindrome.
     * It uses a two-pointer technique to find the middle of the linked list, then reverses the second half of the list.
     * After that, it compares the first half and the reversed second half. If they are the same, then the linked list is a palindrome.
     *
     * @param head The head node of the linked list.
     * @return true if the linked list is a palindrome, false otherwise.
     */
    public boolean isPalindrome(ListNode head) {
        // If the list is empty or has only one node, it is a palindrome
        if (head == null || head.next == null) return true;

        // Initialize two pointers to find the middle of the list
        ListNode slow = head, fast = head, prev = null, next;

        // Move fast two steps at a time and slow one step at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Compare the first half and the reversed second half
        while (prev != null) {
            if (head.val != prev.val) return false;
            head = head.next;
            prev = prev.next;
        }

        // If all nodes matched, the list is a palindrome
        return true;
    }
}