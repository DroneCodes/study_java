package DynamicProgramming;

import java.util.Arrays;

public class PerfectSquares {

    /**
     * Returns the least number of perfect square numbers that sum to n.
     * <p>
     * This method uses dynamic programming to find the minimum number of perfect squares
     * that sum up to the given integer n. It initializes a dp array where dp[i] represents
     * the least number of perfect square numbers that sum to i.
     *
     * @param n The input number.
     * @return The least number of perfect square numbers that sum to n.
     */
    public static int numSquares(int n) {
        // Initialize a dp array of size n + 1 with Integer.MAX_VALUE
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case: 0 can be represented by 0 perfect squares

        // Iterate through all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check all possible perfect squares less than or equal to i
            for (int j = 1; j * j <= i; j++) {
                // Update dp[i] with the minimum value of dp[i] and dp[i - j * j] + 1
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        // Return the least number of perfect square numbers that sum to n
        return dp[n];
    }

    public static void main(String[] args) {
        int n1 = 12;
        int n2 = 13;

        System.out.println(numSquares(n1)); // Output: 3
        System.out.println(numSquares(n2)); // Output: 2
    }
}
