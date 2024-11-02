package Strings.leetcodeQuestions;

/**
 * This class contains a method to find the longest common subsequence between two strings.
 */
public class LongestCommonSubsequence {

    /**
     * Finds the length of the longest common subsequence between two strings.
     *
     * @param text1 The first string.
     * @param text2 The second string.
     * @return The length of the longest common subsequence.
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Fill the dp array from bottom-right to a top-left
        for (int row = n - 1; row >= 0; row--) {
            for (int col = m - 1; col >= 0; col--) {
                if (text1.charAt(row) == text2.charAt(col)) {
                    dp[row][col] = 1 + dp[row + 1][col + 1];
                } else {
                    dp[row][col] = Math.max(dp[row + 1][col], dp[row][col + 1]);
                }
            }
        }

        // The length of the longest common subsequence is in dp[0][0]
        return dp[0][0];
    }
}