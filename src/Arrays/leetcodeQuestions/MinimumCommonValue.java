package Arrays.leetcodeQuestions;

import java.util.Arrays;

public class MinimumCommonValue {
    /**
     * Finds the minimum common value between two sorted arrays.
     * @param nums1 the first sorted array
     * @param nums2 the second sorted array
     * @return the minimum common value if exists, -1 otherwise
     */
    public int findMinCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        Integer minCommon = null;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (minCommon == null || nums1[i] < minCommon) {
                    minCommon = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return minCommon != null ? minCommon : -1;
    }
}