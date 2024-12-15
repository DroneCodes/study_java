package Array.leetcodeQuestions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class ContinuousSubarrays {

    /**
     * Returns the total number of continuous subarrays.
     *
     * @param nums the input array of integers
     * @return the total number of continuous subarrays
     */
    public long continuousSubarrays(int[] nums) {
        // TreeMap to maintain sorted frequency map of current window
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int left = 0, right = 0;
        int n = nums.length;
        long count = 0; // Total count of valid subarrays

        while (right < n) {
            // Add current element to frequency map
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // While window violates the condition |nums[i] - nums[j]| ≤ 2
            // Shrink window from left
            while (freq.lastEntry().getKey() - freq.firstEntry().getKey() > 2) {
                // Remove leftmost element from frequency map
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }

            // Add count of all valid subarrays ending at right
            count += right - left + 1;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        ContinuousSubarrays solution = new ContinuousSubarrays();

        int[] nums1 = {5, 4, 2, 4};
        System.out.println("Total continuous subarrays (Test case 1): " + solution.continuousSubarrays(nums1)); // Expected output: 8

        int[] nums2 = {1, 2, 3};
        System.out.println("Total continuous subarrays (Test case 2): " + solution.continuousSubarrays(nums2)); // Expected output: 6
    }
}