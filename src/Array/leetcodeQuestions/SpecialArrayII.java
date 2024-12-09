package Array.leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class SpecialArrayII {

    /**
     * Checks if the subarrays defined by the queries are special.
     *
     * @param nums the array of integers
     * @param queries the 2D array of queries where each query is a pair of indices [from, to]
     * @return an array of booleans where each element is true if the corresponding subarray is special
     */
    public boolean[] checkSpecialSubarrays(int[] nums, int[][] queries) {
        boolean[] result = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            result[i] = isSpecial(nums, from, to);
        }

        return result;
    }

    /**
     * Checks if the subarray nums[from..to] is special.
     *
     * @param nums the array of integers
     * @param from the starting index of the subarray
     * @param to the ending index of the subarray
     * @return true if the subarray is special, false otherwise
     */
    private boolean isSpecial(int[] nums, int from, int to) {
        for (int i = from; i < to; i++) {
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SpecialArrayII solution = new SpecialArrayII();

        int[] nums1 = {3, 4, 1, 2, 6};
        int[][] queries1 = {{0, 4}};
        boolean[] result1 = solution.checkSpecialSubarrays(nums1, queries1);
        System.out.println("Output (Test case 1): " + java.util.Arrays.toString(result1)); // Expected output: [false]

        int[] nums2 = {4, 3, 1, 6};
        int[][] queries2 = {{0, 2}, {2, 3}};
        boolean[] result2 = solution.checkSpecialSubarrays(nums2, queries2);
        System.out.println("Output (Test case 2): " + java.util.Arrays.toString(result2)); // Expected output: [false, true]
    }
}