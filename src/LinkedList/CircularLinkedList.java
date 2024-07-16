package LinkedList;

import LinkedList.type_declaration.CircularListNode;

/**
 * Represents a circular linked list where the last node points back to the first node.
 */
public class CircularLinkedList {

    protected CircularListNode tail; // The last node of the list. It points to the head.
    protected int length; // The number of nodes in the list.

    /**
     * Constructs an empty CircularLinkedList.
     */
    public CircularLinkedList() {
        tail = null;
        length = 0;
    }

    /**
     * Adds a node with the specified data to the beginning of the list.
     * @param data The data to be added.
     */
    public void add(int data) {
        addToHead(data);
    }


    /**
 * Adds a node with the specified data to the head of the circular linked list.
 * <p>
 * This method creates a new node with the given data and inserts it at the beginning of the list.
 * If the list is currently empty (tail is null), the new node is added as the sole node, pointing to itself.
 * Otherwise, the new node is inserted just after the tail, effectively becoming the new head of the list.
 * The length of the list is incremented to reflect the addition.
 *
 * @param data The data for the new node to be added to the head of the list.
 */
public void addToHead(int data) {
    CircularListNode temp = new CircularListNode(data);
    if (tail == null) { // first data added
        tail = temp;
        tail.setNext(tail);
    } else { // element exists in the list
        temp.setNext(tail.getNext());
        tail.setNext(temp);
    }
    length++;
}

/**
 * Adds a node with the specified data to the tail of the circular linked list.
 * <p>
 * This method leverages the {@code addToHead} method to add the new node to the list,
 * then adjusts the tail pointer to the newly added node, effectively making it the tail.
 * This approach maintains the circular nature of the list while simplifying the addition logic.
 *
 * @param data The data for the new node to be added to the tail of the list.
 */
public void addToTail(int data) {
    addToHead(data);
    tail = tail.getNext();
}

/**
 * Retrieves the data from the head of the circular linked list without removing it.
 * <p>
 * This method returns the data of the node immediately following the tail,
 * which is considered the head of the list in a circular linked list structure.
 * If the list is empty, the behavior of this method is undefined and should be checked by {@code isEmpty()} before calling.
 *
 * @return The data of the head node of the list.
 */
public int peek() {
    return tail.getNext().getData();
}

/**
 * Retrieves the data from the tail of the circular linked list without removing it.
 * <p>
 * This method returns the data of the tail node directly. It provides a way to inspect
 * the value at the end of the list without modifying the list structure.
 * If the list is empty, the behavior of this method is undefined and should be checked by {@code isEmpty()} before calling.
 *
 * @return The data of the tail node of the list.
 */
public int tailPeek() {
    return tail.getData();
}


    /**
 * Removes and returns the data from the head of the circular linked list.
 *
 * This method performs the removal of the node at the head of the circular linked list and returns its data.
 * It first checks if the tail node is pointing to itself, indicating a single-node list, in which case it sets the tail to null,
 * effectively clearing the list. If the list contains more than one node, it adjusts the tail's next pointer to skip the current head
 * and then sets the removed node's next pointer to null to help with garbage collection. The length of the list is decremented,
 * and the data of the removed head node is returned. This operation is O(1) as it requires a constant amount of work.
 *
 * @return The data of the node that was removed from the head of the list.
 */
public int removeFromHead() {
    CircularListNode temp = tail.getNext(); // the head of the list
    if (tail == tail.getNext()) {
        tail = null;
    } else {
        tail.setNext(temp.getNext());
        temp.setNext(null); // helps cleans things up; temp is free
    }
    length--;
    return temp.getData();
}


    /**
 * Removes and returns the data from the tail of the circular linked list.
 *
 * This method checks if the list is empty by calling {@code isEmpty()}. If the list is empty,
 * it returns {@code Integer.MIN_VALUE} as an indication. Otherwise, it traverses the list starting from the tail
 * until it finds the node just before the tail (since it's a circular linked list, every node is reachable from the tail).
 * Once the node before the tail is found, it performs the removal by adjusting the next pointers and updating the tail
 * to the previous node if necessary. The data of the removed tail node is then returned.
 * If the tail was the only node in the list, the tail is set to null, effectively emptying the list.
 *
 * @return The data of the removed tail node, or {@code Integer.MIN_VALUE} if the list is empty.
 */
public int removeFromTail() {
    if (isEmpty()) {
        return Integer.MIN_VALUE;
    }
    CircularListNode finger = tail;
    while (finger.getNext() != tail) {
        finger = finger.getNext();
    }
    // finger now points to the one before tail
    CircularListNode temp = tail;
    if (finger == tail) {
        tail = null;
    } else {
        finger.setNext(tail.getNext());
        tail = finger;
    }
    length--;
    return temp.getData();
}

    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return tail == null;
    }


    /**
 * Checks if the circular linked list contains a node with the specified data.
 *
 * This method begins by checking if the list is empty (tail is null), returning false if it is.
 * If the list is not empty, it initializes a pointer, `finger`, to the node next to the tail (the head of the list)
 * and iterates through the list. During each iteration, it checks if the current node's data matches the specified data.
 * The loop continues until it either finds a matching node or has checked all nodes and returned to the tail.
 * If a node with the specified data is found, the method returns true; otherwise, it returns false.
 *
 * @param data The data to search for in the list.
 * @return true if a node with the specified data is found, false otherwise.
 */
public boolean contains(int data) {
    if (tail == null) {
        return false;
    }
    CircularListNode finger = tail.getNext();
    while (finger != tail && (!(finger.getData() == data))) {
        finger = finger.getNext();
    }
    return finger.getData() == data;
}

    /**
 * Removes the first occurrence of a node with the specified data from the circular linked list.
 *
 * This method searches for the first node containing the specified data and removes it from the list.
 * It maintains two pointers, `finger` and `previous`, to traverse the list and find the target node.
 * If the target node is found, it is removed by adjusting the `next` pointers of the surrounding nodes.
 * If the target node is the tail, the tail pointer is updated to the previous node.
 * The method returns the data of the removed node or Integer.MIN_VALUE if the node is not found or the list is empty.
 *
 * @param data The data of the node to be removed.
 * @return The data of the removed node, or Integer.MIN_VALUE if the node is not found or the list is empty.
 */
public int remove(int data) {
    if (tail == null) {
        return Integer.MIN_VALUE;
    }
    CircularListNode finger = tail.getNext();
    CircularListNode previous = tail;
    int compares;
    for (compares = 0; compares < length && (!(finger.getData() == data)); compares++) {
        previous = finger;
        finger = finger.getNext();
    }
    if (finger.getData() == data) {
        if (tail == tail.getNext()) {
            tail = null;
        } else {
            if (finger == tail) {
                tail = previous;
            }
            previous.setNext(finger.getNext());
        }
        finger.setNext(null); // to keep things disconnected
        length--;
        return finger.getData();
    }
    return Integer.MIN_VALUE;
}

    /**
     * Returns the number of nodes in the list.
     * @return The number of nodes in the list.
     */
    public int size() {
        return length;
    }

    /**
     * Clears the list, removing all nodes.
     */
    public void clear() {
        length = 0;
        tail = null;
    }

   /**
 * Returns a string representation of the circular linked list.
 *
 * This method generates a string representation of the circular linked list in the format: ["data1","data2",...].
 * It starts by checking if the list is empty, in which case it returns "[]". If the list is not empty,
 * it iterates from the node after the tail (the head of the list) to the tail, appending each node's data to the result string.
 * This method ensures that the circular linked list is represented in a clear and concise manner, making it easier to visualize its contents.
 *
 * @return A string representation of the circular linked list.
 */
public String toString() {
    String result = "[";
    if (tail == null) {
        return result + "]";
    }
    result = result + tail.getData();
    CircularListNode temp = tail.getNext();
    while (temp != tail) {
        result = result + "," + temp.getData();
        temp = temp.getNext();
    }
    return result + "]";
}



    // Counting nodes in a Circular Linked List

    /**
 * Counts the number of nodes in a circular linked list.
 *
 * This method starts from the node next to the head and iterates through the list until it reaches the head again,
 * counting the number of nodes encountered. This method assumes that the provided head node is part of a circular linked list.
 * If the list is empty (i.e., the head's next node is the head itself), the count will be 0.
 *
 * @param head The head node of the circular linked list.
 * @return The number of nodes in the circular linked list.
 */
public int countNodes(CircularListNode head) {
    int length = 0;
    CircularListNode current = head.getNext();
    while (current != head) {
        length++;
        current = current.getNext();
    }
    return length;
}

/**
 * Prints the contents of a circular linked list.
 *
 * Starting from the node next to the head, this method iterates through the circular linked list,
 * printing the data of each node followed by a "->" symbol. When it reaches the head again,
 * it prints the head's data and appends "(head)" to indicate the end of the list and that it's circular.
 * This method is useful for debugging or visually verifying the contents of the list.
 *
 * @param head The head node of the circular linked list to print.
 */
public void printList(CircularListNode head) {
    CircularListNode current = head.getNext();
    while (current != head) {
        System.out.print(current.getData() + "->");
        current = current.getNext();
    }
    System.out.println("(" + current.getData() + ")head");
}
}
