package leetcodeQuestions;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;
interface NestedInteger {

              // @return true if this NestedInteger holds a single integer, rather than a nested list.
            public boolean isInteger();

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();
              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return empty list if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
}

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
