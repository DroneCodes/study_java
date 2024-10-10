package Strings.leetcodeQuestions;

import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {
    /**
     * Calculates the minimum length of the string after repeatedly removing the substrings "AB" and "CD".
     *
     * @param s the input string
     * @return the minimum length of the string after removing the substrings
     */
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // Check if the top of the stack and the current character form "AB" or "CD"
            if (!stack.isEmpty() && ((stack.peek() == 'A' && c == 'B') || (stack.peek() == 'C' && c == 'D'))) {
                stack.pop(); // Remove the top of the stack if a valid pair is found
            } else {
                stack.push(c); // Push the current character onto the stack
            }
        }

        return stack.size(); // Return the size of the stack, which is the minimum length of the string
    }

    public static void main(String[] args) {
        MinimumStringLengthAfterRemovingSubstrings solution = new MinimumStringLengthAfterRemovingSubstrings();

        // Test case 1
        String s1 = "ABFCACDB";
        System.out.println(solution.minLength(s1)); // Output: 2

        // Test case 2
        String s2 = "ACBBD";
        System.out.println(solution.minLength(s2)); // Output: 5
    }
}