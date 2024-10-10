package Strings.leetcodeQuestions;

public class MinimumNumberofSwapsToMakeBalanced {
    /**
     * Calculates the minimum number of swaps required to make the string balanced.
     * A string is balanced if every '[' has a corresponding ']'.
     *
     * @param s the input string containing only '[' and ']'
     * @return the minimum number of swaps required to balance the string
     */
    public int minSwaps(String s) {
        int balance = 0;
        int swaps = 0;

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (c == '[') {
                balance++;
            } else {
                balance--;
            }

            // If balance is negative, a swap is needed
            if (balance < 0) {
                swaps++;
                balance = 1; // Reset balance after swap
            }
        }

        return swaps;
    }

    /**
     * Main method to test the minSwaps method with example test cases.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        MinimumNumberofSwapsToMakeBalanced solution = new MinimumNumberofSwapsToMakeBalanced();

        // Test case 1
        String s1 = "][][";
        System.out.println(solution.minSwaps(s1)); // Output: 1

        // Test case 2
        String s2 = "]]][[[";
        System.out.println(solution.minSwaps(s2)); // Output: 2

        // Test case 3
        String s3 = "[]";
        System.out.println(solution.minSwaps(s3)); // Output: 0
    }
}