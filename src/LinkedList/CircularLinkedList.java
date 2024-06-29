package LinkedList;

import LinkedList.type_declaration.CircularListNode;

public class CircularLinkedList {

    // Counting nodes in a Circular Linked List

    public int countNodes(CircularListNode head) {
        int length = 0;
        CircularListNode current = head.getNext();
        while (current != head) {
            length++;
            current = current.getNext();
        }
        return length;
    }
}
