package Array.leetcodeQuestions;

import java.util.Arrays;

public class SpecialArrayII {

    /**
     * Checks if the subarrays defined by the queries are special.
     *
     * @param nums the array of integers
     * @param queries the 2D array of queries where each query is a pair of indices [from, to]
     * @return an array of booleans where each element is true if the corresponding subarray is special
     */
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        // Precompute parity changes
        int[] prefixSum = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            // If parity is different, mark with 1, else 0
            prefixSum[i] = (nums[i-1] % 2 != nums[i] % 2) ? 1 : 0;

            // Convert to prefix sum
            prefixSum[i] += prefixSum[i-1];
        }

        // Process queries
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];

            // If the prefix sum difference is equal to the range length - 1,
            // it means all adjacent pairs have different parity
            result[i] = (prefixSum[to] - prefixSum[from]) == (to - from);
        }

        return result;
    }

    public static void main(String[] args) {
        SpecialArrayII solution = new SpecialArrayII();

        int[] nums1 = {3, 4, 1, 2, 6};
        int[][] queries1 = {{0, 4}};
        boolean[] result1 = solution.isArraySpecial(nums1, queries1);
        System.out.println("Output (Test case 1): " + Arrays.toString(result1)); // Expected output: [false]

        int[] nums2 = {4, 3, 1, 6};
        int[][] queries2 = {{0, 2}, {2, 3}};
        boolean[] result2 = solution.isArraySpecial(nums2, queries2);
        System.out.println("Output (Test case 2): " + Arrays.toString(result2)); // Expected output: [false, true]
    }
}