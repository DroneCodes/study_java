package Array.leetcodeQuestions;

import java.util.Arrays;

public class PowerOfKSizeSubArrays {

    public int[] findPowerOfSubArrays(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            if (isConsecutiveAndSorted(nums, i, k)) {
                results[i] = Arrays.stream(nums, i, i + k).max().getAsInt();
            } else {
                results[i] = -1;
            }
        }

        return results;
    }

    private boolean isConsecutiveAndSorted(int[] nums, int start, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PowerOfKSizeSubArrays solution = new PowerOfKSizeSubArrays();

        int[] nums1 = {1, 2, 3, 4, 3, 2, 5};
        int k1 = 3;
        System.out.println(Arrays.toString(solution.findPowerOfSubArrays(nums1, k1))); // Output: [3, 4, -1, -1, -1]

        int[] nums2 = {2, 2, 2, 2, 2};
        int k2 = 4;
        System.out.println(Arrays.toString(solution.findPowerOfSubArrays(nums2, k2))); // Output: [-1, -1]

        int[] nums3 = {3, 2, 3, 2, 3, 2};
        int k3 = 2;
        System.out.println(Arrays.toString(solution.findPowerOfSubArrays(nums3, k3))); // Output: [-1, 3, -1, 3, -1]
    }
}