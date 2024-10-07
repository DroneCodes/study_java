package Strings.leetcodeQuestions;

import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && ((stack.peek() == 'A' && c == 'B') || (stack.peek() == 'C' && c == 'D'))) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size();
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