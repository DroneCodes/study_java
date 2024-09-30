package LinkedList.leetcodeQuestions;

public class DesignCircularDeque {
    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    /**
     * Initializes the deque with a maximum size of k.
     *
     * @param k the maximum size of the deque
     */
    public DesignCircularDeque(int k) {
        capacity = k;
        deque = new int[k];
        front = 0;
        rear = k - 1;
        size = 0;
    }

    /**
     * Adds an item at the front of Deque.
     *
     * @param value the value to be added
     * @return true if the operation is successful, false otherwise
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque.
     *
     * @param value the value to be added
     * @return true if the operation is successful, false otherwise
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % capacity;
        deque[rear] = value;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque.
     *
     * @return true if the operation is successful, false otherwise
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque.
     *
     * @return true if the operation is successful, false otherwise
     */
    public boolean deleteLast() {
    if (isEmpty()) {
        return false;
    }
    rear = (rear - 1 + capacity) % capacity;
    size--;
    return true;
}

    /**
     * Returns the front item from the Deque.
     *
     * @return the front item, or -1 if the deque is empty
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[front];
    }

    /**
     * Returns the last item from Deque.
     *
     * @return the last item, or -1 if the deque is empty
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deque[rear];
    }

    /**
     * Returns true if the deque is empty.
     *
     * @return true if the deque is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if the deque is full.
     *
     * @return true if the deque is full, false otherwise
     */
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        DesignCircularDeque myCircularDeque = new DesignCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));  // return True
        System.out.println(myCircularDeque.insertLast(2));  // return True
        System.out.println(myCircularDeque.insertFront(3)); // return True
        System.out.println(myCircularDeque.insertFront(4)); // return False, the queue is full.
        System.out.println(myCircularDeque.getRear());      // return 2
        System.out.println(myCircularDeque.isFull());       // return True
        System.out.println(myCircularDeque.deleteLast());   // return True
        System.out.println(myCircularDeque.insertFront(4)); // return True
        System.out.println(myCircularDeque.getFront());     // return 4
    }
}

