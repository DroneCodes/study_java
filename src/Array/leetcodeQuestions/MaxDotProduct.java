package Array.leetcodeQuestions;

public class MaxDotProduct {
    public static int maxDotProduct(int[] nums1, int[] nums2) {
        // Get the lengths of the input arrays
        int m = nums1.length;
        int n = nums2.length;

        // Create a 2D array to store intermediate results
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the dp array with negative infinity for the first row and column
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Integer.MIN_VALUE; // Initialize with negative infinity
                } else {
                    // Calculate the maximum dot product considering three possibilities:
                    // 1. The previous result without the current elements (dp[i-1][j] and dp[i][j-1])
                    // 2. The current elements' product plus the result without the current elements (dp[i-1][j-1] + nums1[i-1] * nums2[j-1])
                    // 3. The previous result (dp[i-1][j-1]) if the product is negative, as negative values can reduce the result
                    dp[i][j] = Math.max(dp[i - 1][j - 1], 0) + nums1[i - 1] * nums2[j - 1];

                    // Update dp[i][j] with the maximum of the three possibilities
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        // The final result is stored in dp[m][n]
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, -1};
        int[] nums2 = {1, 1};
        int result = maxDotProduct(nums1, nums2);
        System.out.println("Maximum Dot Product: " + result);
    }
}
