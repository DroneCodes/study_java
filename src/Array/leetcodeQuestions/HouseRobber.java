package Array.leetcodeQuestions;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // dp[i] represents the maximum amount of money you can rob from the first i houses.
        for (int i = 2; i < n; i++) {
            // You can either rob the current house or the previous house.
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        // To rob the last house, you can either rob the last house or the second-to-last house.
        return Math.max(dp[n - 1], dp[n - 2]);
    }
}
