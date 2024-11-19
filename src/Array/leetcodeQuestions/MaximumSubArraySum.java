package Array.leetcodeQuestions;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides a method to find the maximum subarray sum of all subarrays
 * of a given length k with distinct elements.
 */
public class MaximumSubArraySum {

    /**
     * Finds the maximum subarray sum of all subarrays of length k with distinct elements.
     *
     * @param nums the input array of integers
     * @param k the length of the subarray
     * @return the maximum subarray sum of all subarrays that meet the conditions, or 0 if no subarray meets the conditions
     */
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> elements = new HashSet<>();
        long currentSum = 0;
        long maxSum = 0;
        int begin = 0;

        for (int end = 0; end < n; end++) {
            if (!elements.contains(nums[end])) {
                currentSum += nums[end];
                elements.add(nums[end]);

                if (end - begin + 1 == k) {
                    maxSum = Math.max(maxSum, currentSum);
                    currentSum -= nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
            } else {
                while (nums[begin] != nums[end]) {
                    currentSum -= nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
                begin++;
            }
        }
        return maxSum;
    }

    /**
     * Main method to test the maximumSubarraySum method with different examples.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        MaximumSubArraySum solution = new MaximumSubArraySum();

        int[] nums1 = {1, 5, 4, 2, 9, 9, 9};
        int k1 = 3;
        System.out.println(solution.maximumSubarraySum(nums1, k1)); // Output: 15

        int[] nums2 = {4, 4, 4};
        int k2 = 3;
        System.out.println(solution.maximumSubarraySum(nums2, k2)); // Output: 0
    }
}