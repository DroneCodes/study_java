package Stacks.questions;

import java.util.Stack;

public class BalancingOfSymbols {
    /**
 * Checks if the given string of symbols has balanced parentheses, brackets, and braces.
 *
 * @param s the string containing symbols to be checked
 * @return true if the symbols are balanced, false otherwise
 */
public boolean isValidSymbolPatter(String s) {
    Stack<Character> stack = new Stack<Character>();
    if (s == null || s.length() == 0) {
        return true;
    }
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ')') {
            if (stack.isEmpty() || stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        } else if (s.charAt(i) == ']') {
            if (stack.isEmpty() || stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        } else if (s.charAt(i) == '}') {
            if (stack.isEmpty() || stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        } else {
            stack.push(s.charAt(i));
        }
    }
    if (stack.isEmpty()) {
        return true;
    } else {
        return false;
    }
}
}
