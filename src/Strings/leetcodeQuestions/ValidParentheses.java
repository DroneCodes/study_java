package Strings.leetcodeQuestions;

import java.util.Stack;

/**
 * This class contains a method to validate a string of parentheses.
 */
public class ValidParentheses {

    /**
     * This method checks if a string of parentheses is valid.
     * A valid string of parentheses is defined as one where:
     * 1. Open brackets must be closed by the same type of brackets.
     * 2. Open brackets must be closed in the correct order.
     * 3. Every close bracket has a corresponding open bracket of the same type.
     *
     * @param s The string of parentheses to validate.
     * @return true if the string is valid, false otherwise.
     */
    public boolean isValid(String s) {
        // Initialize a stack to keep track of the opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate over each character in the string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it into the stack
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                // If the character is a closing bracket, check if it matches the last opening bracket
                // If the stack is empty or the brackets don't match, return false
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If there are any unmatched opening brackets left in the stack, return false
        // Otherwise, return true
        return stack.isEmpty();
    }
}