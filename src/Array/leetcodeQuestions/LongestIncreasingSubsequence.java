package Array.leetcodeQuestions;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i]= maxVal + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
