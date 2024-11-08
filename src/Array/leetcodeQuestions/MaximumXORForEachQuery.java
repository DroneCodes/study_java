package Array.leetcodeQuestions;

public class MaximumXORForEachQuery {

    /**
     * Computes the maximum XOR for each query.
     *
     * @param nums An array of integers.
     * @param maximumBit The maximum number of bits to consider for the XOR operation.
     * @return An array of integers representing the maximum XOR for each query.
     */
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] res = new int[n];
        int max = (1 << maximumBit) - 1;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
            res[n - i - 1] = xor ^ max;
        }
        return res;
    }
}