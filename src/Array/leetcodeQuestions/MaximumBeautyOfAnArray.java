package Array.leetcodeQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumBeautyOfAnArray {

    /**
     * Returns the maximum possible beauty of the array after applying the operations.
     *
     * @param nums the input array
     * @param k the non-negative integer
     * @return the maximum possible beauty of the array
     */
    public int maximumBeauty(int[] nums, int k) {
        // Sort the array first
        Arrays.sort(nums);

        int maxBeauty = 0;
        int left = 0;

        // Use sliding window approach
        for (int right = 0; right < nums.length; right++) {
            // While the difference between max and min in current window exceeds 2k
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }

            // Update max beauty (window size)
            maxBeauty = Math.max(maxBeauty, right - left + 1);
        }

        return maxBeauty;
    }

    public static void main(String[] args) {
        MaximumBeautyOfAnArray solution = new MaximumBeautyOfAnArray();

        int[] nums1 = {4, 6, 1, 2};
        int k1 = 2;
        System.out.println("Output (Test case 1): " + solution.maximumBeauty(nums1, k1)); // Expected output: 3

        int[] nums2 = {1, 1, 1, 1};
        int k2 = 10;
        System.out.println("Output (Test case 2): " + solution.maximumBeauty(nums2, k2)); // Expected output: 4
    }
}