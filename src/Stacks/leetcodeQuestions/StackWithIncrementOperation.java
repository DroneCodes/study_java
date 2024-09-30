package Stacks.leetcodeQuestions;

public class StackWithIncrementOperation {
    private int[] stack;
    private int[] increment;
    private int top;

    /**
     * Initializes the object with maxSize which is the maximum number of elements in the stack.
     *
     * @param maxSize the maximum size of the stack
     */
    public StackWithIncrementOperation(int maxSize) {
        stack = new int[maxSize];
        increment = new int[maxSize];
        top = -1;
    }

    /**
     * Adds x to the top of the stack if the stack has not reached the maxSize.
     *
     * @param x the value to be added to the stack
     */
    public void push(int x) {
        if (top < stack.length - 1) {
            stack[++top] = x;
        }
    }

    /**
     * Pops and returns the top of the stack or -1 if the stack is empty.
     *
     * @return the top of the stack or -1 if the stack is empty
     */
    public int pop() {
        if (top == -1) {
            return -1;
        }
        int result = stack[top] + increment[top];
        if (top > 0) {
            increment[top - 1] += increment[top];
        }
        increment[top] = 0;
        top--;
        return result;
    }

    /**
     * Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.
     *
     * @param k the number of elements to increment from the bottom
     * @param val the value to increment the elements by
     */
    public void inc(int k, int val) {
        int limit = Math.min(k, top + 1);
        if (limit > 0) {
            increment[limit - 1] += val;
        }
    }

    public static void main(String[] args) {
        StackWithIncrementOperation stk = new StackWithIncrementOperation(3); // Stack is Empty []
        stk.push(1);                          // stack becomes [1]
        stk.push(2);                          // stack becomes [1, 2]
        System.out.println(stk.pop());        // return 2 --> Return top of the stack 2, stack becomes [1]
        stk.push(2);                          // stack becomes [1, 2]
        stk.push(3);                          // stack becomes [1, 2, 3]
        stk.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4
        stk.inc(5, 100);                      // stack becomes [101, 102, 103]
        stk.inc(2, 100);                      // stack becomes [201, 202, 103]
        System.out.println(stk.pop());        // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        System.out.println(stk.pop());        // return 202 --> Return top of the stack 202, stack becomes [201]
        System.out.println(stk.pop());        // return 201 --> Return top of the stack 201, stack becomes []
        System.out.println(stk.pop());        // return -1 --> Stack is empty return -1.
    }
}
