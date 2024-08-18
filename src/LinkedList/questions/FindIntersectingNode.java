package LinkedList.questions;

import LinkedList.type_declaration.ListNode;

public class FindIntersectingNode {
    public static ListNode findIntersectingNode(ListNode list1, ListNode list2) {
        int l1 = 0, l2 =0, diff = 0;
        ListNode temp1 = list1, temp2 = list2;
        while (temp1 != null) {
            l1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            l2++;
            temp2 = temp2.next;
        }
        if (l1 < l2) {
            temp1 = list2;
            temp2 = list1;
            diff = l2 - l1;
        } else {
            temp1 = list1;
            temp2 = list2;
            diff = l1 - l2;
        }
        for (int i = 0; i < diff; i++) {
            temp1 = temp1.next;
            while (temp1 != null && temp2 != null) {
                if (temp1 == temp2) {
                    return temp1;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        return null;
    }
}
