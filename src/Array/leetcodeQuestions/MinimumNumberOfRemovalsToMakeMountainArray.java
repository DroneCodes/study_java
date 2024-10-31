package Array.leetcodeQuestions;

public class MinimumNumberOfRemovalsToMakeMountainArray {

    /**
     * Finds the minimum number of elements to remove to make the given array a mountain array.
     *
     * A mountain array is defined as an array where:
     * - The length of the array is at least 3.
     * - There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
     *   arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
     *
     * The function uses dynamic programming to find the longest increasing subsequence (LIS) from the start
     * to the peak and the longest decreasing subsequence (LDS) from the peak to the end. The minimum number
     * of removals will be the total length of the array minus the length of the longest mountain subsequence.
     *
     * @param nums the input array of integers
     * @return the minimum number of elements to remove to make the array a mountain array
     */
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n]; // Longest Increasing Subsequence
        int[] lds = new int[n]; // Longest Decreasing Subsequence

        // Compute LIS for each element
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Compute LDS for each element
        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Find the maximum length of the mountain array
        int maxMountainLength = 0;
        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) { // Peak element must be part of both LIS and LDS
                maxMountainLength = Math.max(maxMountainLength, lis[i] + lds[i] - 1);
            }
        }

        // Minimum removals to make the array a mountain array
        return n - maxMountainLength;
    }
}