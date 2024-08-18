package LinkedList.questions;

import LinkedList.type_declaration.ListNode;

public class InsertNodeInSortedLinkedList {
    public ListNode insertNode(ListNode head, ListNode newNode) {
        ListNode current = head;
        if (head == null) {
            return newNode;
        }
        // traverse the list until you find item bigger than the new node value
        ListNode temp = null;
        while (current != null && current.getData() < newNode.getData()) {
            temp = current;
            current = current.getNext();
        }
        // insert the new node before the bigger node
        newNode.setNext(current);
        temp.setNext(newNode);
        return head;
    }
}
