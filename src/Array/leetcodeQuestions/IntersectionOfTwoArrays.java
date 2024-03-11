package Array.leetcodeQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The IntersectionOfTwoArrays class provides a method to find the intersection of two integer arrays.
 */
public class IntersectionOfTwoArrays {

    /**
     * This method finds the intersection of two integer arrays.
     * Each element in the result is unique.
     *
     * @param nums1 An array of integers. Each integer is between 0 and 1000 inclusive.
     * @param nums2 An array of integers. Each integer is between 0 and 1000 inclusive.
     * @return An array of integers that are the intersection of nums1 and nums2.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // A set to store the unique elements in nums1.
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // A set to store the unique elements in nums2.
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        // Find the intersection of set1 and set2.
        set1.retainAll(set2);

        // Convert the intersection set to an array.
        int[] result = new int[set1.size()];
        int i = 0;
        for (int num : set1) {
            result[i++] = num;
        }

        return result;
    }
}