package Array.leetcodeQuestions;

public class CountNumberOfMaximumBitwiseORSubsets {
    private int maxOR;
    private int count;

    public int countMaxORSubsets(int[] nums) {
        maxOR = 0;
        count = 0;

        // Find the maximum bitwise OR
        for (int num : nums) {
            maxOR |= num;
        }

        // Start the recursive function to count subsets
        countSubsets(nums, 0, 0);

        return count;
    }

    private void countSubsets(int[] nums, int index, int currentOR) {
        if (index == nums.length) {
            if (currentOR == maxOR) {
                count++;
            }
            return;
        }

        // Include the current element in the subset
        countSubsets(nums, index + 1, currentOR | nums[index]);

        // Exclude the current element from the subset
        countSubsets(nums, index + 1, currentOR);
    }

    public static void main(String[] args) {
        CountNumberOfMaximumBitwiseORSubsets solution = new CountNumberOfMaximumBitwiseORSubsets();

        // Test case 1
        int[] nums1 = {3, 1};
        System.out.println(solution.countMaxORSubsets(nums1)); // Output: 2

        // Test case 2
        int[] nums2 = {2, 2, 2};
        System.out.println(solution.countMaxORSubsets(nums2)); // Output: 7

        // Test case 3
        int[] nums3 = {3, 2, 1, 5};
        System.out.println(solution.countMaxORSubsets(nums3)); // Output: 6
    }
}