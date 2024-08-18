package LinkedList;

import java.util.Random;

/**
 * A SkipList implementation that supports generic keys and values.
 *
 * @param <T> the type of keys, which must be comparable
 * @param <U> the type of values
 */
public class SkipList<T extends Comparable<T>, U> {
    /**
     * Represents a node in the SkipList.
     */
    private class Node {
        public T key;      // The key of the node
        public U value;    // The value associated with the key
        public long level; // The level of the node in the SkipList
        public Node next;  // The next node at the same level
        public Node down;  // The node below at the next lower level

        /**
         * Constructs a new Node.
         *
         * @param key the key of the node
         * @param value the value associated with the key
         * @param level the level of the node
         * @param next the next node at the same level
         * @param down the node below at the next lower level
         */
        public Node(T key, U value, long level, Node next, Node down) {
            this.key = key;
            this.value = value;
            this.level = level;
            this.next = next;
            this.down = down;
        }
    }

    private Node head;       // The head node of the SkipList
    private Random _random;  // Random number generator for level determination
    private long size;       // The number of elements in the SkipList
    private double _p;       // The probability used to determine the level of nodes

    /**
     * Determines the level for a new node.
     *
     * @return the level for the new node
     */
    private long level() {
        long level = 0;
        while (level <= size && _random.nextDouble() < _p) {
            level++;
        }
        return level;
    }

    /**
     * Constructs an empty SkipList with a default probability of 0.5.
     */
    public SkipList() {
        head = new Node(null, null, 0, null, null);
        _random = new Random();
        size = 0;
        _p = 0.5;
    }

    /**
     * Adds a key-value pair to the SkipList.
     *
     * @param key the key to be added
     * @param value the value associated with the key
     */
    public void add(T key, U value) {
        long level = level();
        if (level > head.level) {
            head = new Node(null, null, level, null, head);
        }
        Node cur = head;
        Node last = null;
        while (cur != null) {
            if (cur.next == null || cur.next.key.compareTo(key) > 0) {
                if (level >= cur.level) {
                    Node n = new Node(key, value, cur.level, cur.next, null);
                    if (last != null) {
                        last.down = n;
                    }
                    cur.next = n;
                    last = n;
                }
                cur = cur.down;
                continue;
            } else if (cur.next.key.equals(key)) {
                cur.next.value = value;
                return;
            }
            cur = cur.next;
        }
        size++;
    }

    /**
     * Checks if the SkipList contains the specified key.
     *
     * @param key the key to check for
     * @return true if the key is present, false otherwise
     */
    public boolean containsKey(T key) {
        return get(key) != null;
    }

    /**
     * Removes the key-value pair with the specified key from the SkipList.
     *
     * @param key the key to be removed
     * @return the value associated with the removed key, or null if the key was not found
     */
    public U remove(T key) {
        U value = null;
        Node cur = head;
        while (cur != null) {
            if (cur.next == null || cur.next.key.compareTo(key) >= 0) {
                if (cur.next != null && cur.next.key.equals(key)) {
                    value = cur.next.value;
                    cur.next = cur.next.next;
                }
                cur = cur.down;
                continue;
            }
            cur = cur.next;
        }
        size--;
        return value;
    }

    /**
     * Retrieves the value associated with the specified key.
     *
     * @param key the key to retrieve the value for
     * @return the value associated with the key, or null if the key was not found
     */
    public U get(T key) {
        Node cur = head;
        while (cur != null) {
            if (cur.next == null || cur.next.key.compareTo(key) > 0) {
                cur = cur.down;
                continue;
            } else if (cur.next.key.equals(key)) {
                return cur.next.value;
            }
            cur = cur.next;
        }
        return null;
    }
}

