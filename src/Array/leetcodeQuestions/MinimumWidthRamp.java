package Array.leetcodeQuestions;

public class MinimumWidthRamp {
    /**
     * Finds the maximum width of a ramp in the given integer array.
     * A ramp is defined as a pair (i, j) where i < j and nums[i] <= nums[j].
     * The width of the ramp is defined as j - i.
     *
     * @param nums the input array of integers
     * @return the maximum width of a ramp in the array, or 0 if no ramp exists
     */
    public int maxWidthRamp(int[] nums) {
        int n = nums.length; // Length of the input array
        int max = 0; // Variable to store the maximum width of the ramp found

        // Iterate through each element in the array as the starting point of the ramp
        for (int i = 0; i < n; i++) {
            // Iterate through each element after the current starting point as the ending point of the ramp
            for (int j = n - 1; j > i; j--) {
                // Check if the current pair (i, j) forms a valid ramp
                if (nums[i] <= nums[j]) {
                    // Update the maximum width of the ramp if the current ramp is wider
                    max = Math.max(max, j - i);
                    break; // Break the inner loop as we found the widest ramp for the current starting point
                }
            }
        }

        return max; // Return the maximum width of the ramp found
    }

    /**
     * Main method to test the maxWidthRamp method with example test cases.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        MinimumWidthRamp obj = new MinimumWidthRamp();

        // Test case 1
        int[] nums1 = {6, 0, 8, 2, 1, 5};
        System.out.println(obj.maxWidthRamp(nums1)); // Output: 4

        // Test case 2
        int[] nums2 = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        System.out.println(obj.maxWidthRamp(nums2)); // Output: 7
    }
}