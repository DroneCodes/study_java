package LinkedList.leetcodeQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The AllOneDataStructure class implements a data structure to store the strings' count
 * with the ability to return the strings with minimum and maximum counts.
 */
public class AllOneDataStructure {
    /**
     * Node class represents a node in the double-linked list, storing the count and a set of keys with that count.
     */
    private static class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        /**
         * Constructor to initialize a node with a given count.
         *
         * @param count the count of the node
         */
        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Map<String, Node> keyNodeMap;
    private Node head, tail;

    /**
     * Constructor to initialize the AllOneDataStructure object.
     */
    public AllOneDataStructure() {
        keyNodeMap = new HashMap<>();
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Increments the count of the string key by 1. If key does not exist, insert it with count 1.
     *
     * @param key the string key to be incremented
     */
    public void inc(String key) {
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.keys.remove(key);
            if (node.next.count != node.count + 1) {
                Node newNode = new Node(node.count + 1);
                newNode.keys.add(key);
                insertNodeAfter(node, newNode);
            } else {
                node.next.keys.add(key);
            }
            keyNodeMap.put(key, node.next);
            if (node.keys.isEmpty()) {
                removeNode(node);
            }
        } else {
            if (head.next.count != 1) {
                Node newNode = new Node(1);
                newNode.keys.add(key);
                insertNodeAfter(head, newNode);
            } else {
                head.next.keys.add(key);
            }
            keyNodeMap.put(key, head.next);
        }
    }

    /**
     * Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it.
     *
     * @param key the string key to be decremented
     */
    public void dec(String key) {
        Node node = keyNodeMap.get(key);
        node.keys.remove(key);
        if (node.count > 1) {
            if (node.prev.count != node.count - 1) {
                Node newNode = new Node(node.count - 1);
                newNode.keys.add(key);
                insertNodeAfter(node.prev, newNode);
            } else {
                node.prev.keys.add(key);
            }
            keyNodeMap.put(key, node.prev);
        } else {
            keyNodeMap.remove(key);
        }
        if (node.keys.isEmpty()) {
            removeNode(node);
        }
    }

    /**
     * Returns one of the keys with the maximal count. If no element exists, return an empty string.
     *
     * @return the key with the maximal count or an empty string if no element exists
     */
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    /**
     * Returns one of the keys with the minimum count. If no element exists, return an empty string.
     *
     * @return the key with the minimum count or an empty string if no element exists
     */
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    /**
     * Inserts a new node after a given node in the linked list.
     *
     * @param prevNode the node after which the new node will be inserted
     * @param newNode the new node to be inserted
     */
    private void insertNodeAfter(Node prevNode, Node newNode) {
        newNode.prev = prevNode;
        newNode.next = prevNode.next;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }

    /**
     * Removes a node from the linked list.
     *
     * @param node the node to be removed
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * Main method to demonstrate the usage of the AllOneDataStructure class.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        AllOneDataStructure allOne = new AllOneDataStructure();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey()); // return "hello"
        System.out.println(allOne.getMinKey()); // return "hello"
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey()); // return "hello"
        System.out.println(allOne.getMinKey()); // return "leet"
    }
}