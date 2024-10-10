package Array.leetcodeQuestions;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {
    /**
     * Finds the length of the smallest subarray that needs to be removed
     * so that the sum of the remaining elements is divisible by p.
     *
     * @param nums the array of positive integers
     * @param p the integer by which the sum should be divisible
     * @return the length of the smallest subarray to remove, or -1 if impossible
     */
    public int minSubarray(int[] nums, int p) {
        // Calculate the total sum modulo p
        int totalSum = 0;
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }
        // If the total sum is already divisible by p, return 0
        if (totalSum == 0) {
            return 0;
        }

        // Map to store prefix sums and their indices
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1);
        int prefixSum = 0;
        int minLength = nums.length;

        // Iterate through the array to find the smallest subarray to remove
        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % p;
            int target = (prefixSum - totalSum + p) % p;
            if (prefixSumMap.containsKey(target)) {
                minLength = Math.min(minLength, i - prefixSumMap.get(target));
            }
            prefixSumMap.put(prefixSum, i);
        }

        // Return the length of the smallest subarray to remove, or -1 if impossible
        return minLength == nums.length ? -1 : minLength;
    }

    public static void main(String[] args) {
        MakeSumDivisibleByP solution = new MakeSumDivisibleByP();

        // Test case 1
        int[] nums1 = {3, 1, 4, 2};
        int p1 = 6;
        System.out.println(solution.minSubarray(nums1, p1)); // Output: 1

        // Test case 2
        int[] nums2 = {6, 3, 5, 2};
        int p2 = 9;
        System.out.println(solution.minSubarray(nums2, p2)); // Output: 2

        // Test case 3
        int[] nums3 = {1, 2, 3};
        int p3 = 3;
        System.out.println(solution.minSubarray(nums3, p3)); // Output: 0
    }
}