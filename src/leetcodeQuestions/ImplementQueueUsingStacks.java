package leetcodeQuestions;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    /*
    To implement a queue using two stacks in Java, we can use one stack for enqueue operation and the other for dequeue operation.  Here is the pseudocode for the operations:
    push(int x): Push x to the back of the queue.
    Push x to the top of stack1.
    pop(): Remove the element from the front of the queue and return it.
    If stack2 is empty, while stack1 is not empty, pop an element from stack1 and push it to stack2.
    Pop the top element from stack2 and return it.
    peek(): Return the element at the front of the queue.
    If stack2 is empty, while stack1 is not empty, pop an element from stack1 and push it to stack2.
    Return the top element of stack2.
    empty(): Return true if the queue is empty, false otherwise.
    The queue is empty if both stack1 and stack2 are empty.
     */

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public void MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
