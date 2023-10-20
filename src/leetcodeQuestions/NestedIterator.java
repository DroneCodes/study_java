package leetcodeQuestions;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// Leetcode Question 341
public class NestedIterator implements Iterator<Integer> {

    //Stack<NestedInteger> stack = new Stack<>();
    Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList==null) {
            return;
        }
        for (int i = nestedList.size()-1; i >=0 ; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if (curr.isInteger()) {
                return true;
            } else {
                stack.pop();
                for (int i = curr.getList().size() - 1; i >=0 ; i--) {
                    stack.push(curr.getList().get(i));
                }
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }
}
