package Array.leetcodeQuestions;

import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations {
    /**
     * Returns the maximum possible score after applying exactly k operations.
     *
     * @param nums the array of integers
     * @param k the number of operations
     * @return the maximum possible score
     */
    public long maxKelements(int[] nums, int k) {
        // Max-heap to keep track of the largest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxHeap.add(num);
        }

        long score = 0;

        // Perform k operations
        for (int i = 0; i < k; i++) {
            int maxElement = maxHeap.poll();
            score += maxElement;
            maxHeap.add((int) Math.ceil(maxElement / 3.0));
        }

        return score;
    }

    public static void main(String[] args) {
        MaximalScoreAfterApplyingKOperations solution = new MaximalScoreAfterApplyingKOperations();

        // Test case 1
        int[] nums1 = {10, 10, 10, 10, 10};
        int k1 = 5;
        System.out.println(solution.maxKelements(nums1, k1)); // Output: 50

        // Test case 2
        int[] nums2 = {1, 10, 3, 3, 3};
        int k2 = 3;
        System.out.println(solution.maxKelements(nums2, k2)); // Output: 17
    }
}