package Array.leetcodeQuestions;

import java.util.Arrays;

public class CountTheNumberOfFairPairs {

    /**
     * Counts the number of fair pairs (i, j) in the array such that:
     * 0 <= i < j < n, and lower <= nums[i] + nums[j] <= upper.
     *
     * @param nums the input array of integers
     * @param lower the lower bound of the sum
     * @param upper the upper bound of the sum
     * @return the number of fair pairs
     */
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums); // Sort the array to use two-pointer technique
        return countLess(nums, upper) - countLess(nums, lower - 1); // Calculate the number of pairs within the range
    }

    /**
     * Counts the number of pairs (i, j) such that nums[i] + nums[j] <= sum.
     *
     * @param nums the sorted array of integers
     * @param sum the upper bound of the sum
     * @return the number of pairs with sum less than or equal to the given sum
     */
    private long countLess(int[] nums, int sum) {
        long res = 0; // Initialize the result counter
        for (int i = 0, j = nums.length - 1; i < j; ++i) { // Iterate through the array with two pointers
            while (i < j && nums[i] + nums[j] > sum) // Move the right pointer to find valid pairs
                --j;
            res += j - i; // Count the number of valid pairs for the current i
        }
        return res; // Return the total count of valid pairs
    }

    public static void main(String[] args) {
        CountTheNumberOfFairPairs solution = new CountTheNumberOfFairPairs();

        int[] nums1 = {0, 1, 7, 4, 4, 5};
        int lower1 = 3;
        int upper1 = 6;
        System.out.println(solution.countFairPairs(nums1, lower1, upper1)); // Output: 6

        int[] nums2 = {1, 7, 9, 2, 5};
        int lower2 = 11;
        int upper2 = 11;
        System.out.println(solution.countFairPairs(nums2, lower2, upper2)); // Output: 1
    }
}