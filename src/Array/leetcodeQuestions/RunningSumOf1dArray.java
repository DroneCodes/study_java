package Array.leetcodeQuestions;

public class RunningSumOf1dArray {
        public int[] runningSum(int[] nums) {
            int length = nums.length;
            int[] newSum = new int[length];
            newSum[0] = nums[0];

            for(int i = 1; i <= nums.length; i++) {
                newSum[i] = newSum[i - 1] + nums[i];
            }

            return newSum;
        }
}
