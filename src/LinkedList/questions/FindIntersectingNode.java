package LinkedList.questions;

import LinkedList.type_declaration.ListNode;

public class FindIntersectingNode {

    /**
     * Finds the intersecting node of two singly linked lists.
     *
     * @param list1 the head of the first singly linked list
     * @param list2 the head of the second singly linked list
     * @return the intersecting node, or null if there is no intersection
     *
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     */
    public static ListNode findIntersectingNode(ListNode list1, ListNode list2) {
        int l1 = 0, l2 = 0, diff = 0;
        ListNode temp1 = list1, temp2 = list2;

        // Calculate the length of the first list
        while (temp1 != null) {
            l1++;
            temp1 = temp1.next;
        }

        // Calculate the length of the second list
        while (temp2 != null) {
            l2++;
            temp2 = temp2.next;
        }

        // Determine the longer list and the difference in lengths
        if (l1 < l2) {
            temp1 = list2;
            temp2 = list1;
            diff = l2 - l1;
        } else {
            temp1 = list1;
            temp2 = list2;
            diff = l1 - l2;
        }

        // Advance the pointer of the longer list by the difference in lengths
        for (int i = 0; i < diff; i++) {
            temp1 = temp1.next;
        }

        // Traverse both lists together to find the intersection
        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        // Return null if no intersection is found
        return null;
    }
}