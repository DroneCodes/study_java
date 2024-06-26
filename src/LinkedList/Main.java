package LinkedList;

import LinkedList.type_declaration.ListNode;

public class Main {

    /*
        Traversing a linked list

        To traverse a linked list we do the following
        1. Follow the pointers
        2. Display the content of each node as they are traversed, or you count the number of nodes in the list
        3. Stop when you reach the end of the list (when the pointer is null)


        Time complexity: O(n), where n is the number of nodes in the list
        Space complexity: O(1), for creating a temporary variable to store the current node

        The following code snippet shows how to traverse a linked list and count the number of nodes in the list.
     */

    public int ListLength(ListNode head) {
        int length = 0;
        ListNode current = head;

        while (current != null) {
            length++;
            current = current.getNext();
        }

        return length;
    }


    /*
        Singly Linked List Insertion

        Insertion into a singly-linked list has three cases:

        1. Inserting a new node before the head of the list (at the beginning).
        2. Inserting a new node after the tail of the list (at the end).
        3. Inserting a new node at a specific position in the list (at the middle).

        Note: To insert an element in the linked list at some point p, assume that after inserting the element the position of this new node is p

        Time complexity: O(1), since the worst case we may need to insert the node at the end of the list
        Space complexity: O(1), for creating a temporary variable to store the new node
     */

    /*
        Singly Linked List Deletion

        Deletion in a singly-linked list has three cases:

        1. Deleting the head of the list (the first node).
        2. Deleting the tail of the list (the last node).
        3. Deleting a node at a specific position in the list (at the middle).


        Time complexity: O(1), since the worst case we may need to delete the node at the end of the list
        Space complexity: O(1), for creating a temporary variable to store the new node
     */


}
