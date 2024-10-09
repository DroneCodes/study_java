package Strings.leetcodeQuestions;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int balance = 0;
        int insertions = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
                if (balance < 0) {
                    insertions++;
                    balance = 0;
                }
            }
        }

        return balance + insertions;
    }

    public static void main(String[] args) {
        MinimumAddToMakeParenthesesValid solution = new MinimumAddToMakeParenthesesValid();

        // Test case 1
        String s1 = "())";
        System.out.println(solution.minAddToMakeValid(s1)); // Output: 1

        // Test case 2
        String s2 = "(((";
        System.out.println(solution.minAddToMakeValid(s2)); // Output: 3
    }
}