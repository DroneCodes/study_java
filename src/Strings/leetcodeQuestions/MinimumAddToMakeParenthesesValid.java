package Strings.leetcodeQuestions;

public class MinimumAddToMakeParenthesesValid {
    /**
     * Calculates the minimum number of parentheses insertions needed to make the input string valid.
     * A string is valid if every opening parenthesis '(' has a corresponding closing parenthesis ')'.
     *
     * @param s the input string containing only '(' and ')'
     * @return the minimum number of insertions needed to make the string valid
     */
    public int minAddToMakeValid(String s) {
        int balance = 0;
        int insertions = 0;

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
                // If balance is negative, an insertion is needed
                if (balance < 0) {
                    insertions++;
                    balance = 0; // Reset balance after insertion
                }
            }
        }

        return balance + insertions; // Return total insertions needed
    }

    /**
     * Main method to test the minAddToMakeValid method with example test cases.
     *
     * @param args command line arguments
     */
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