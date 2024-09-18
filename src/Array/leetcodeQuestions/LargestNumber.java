package Array.leetcodeQuestions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This class provides a method to arrange a list of non-negative integers such that they form the largest number.
 */
public class LargestNumber {

    /**
     * Arranges the given list of non-negative integers to form the largest number.
     * <p>
     * This method works as follows:
     * 1. Converts the list of integers to a list of strings.
     * 2. Sorts the list of strings using a custom comparator. The comparator compares two strings by their concatenated results in both possible orders.
     * 3. Joins the sorted list of strings to form the largest number.
     * 4. Handles the edge case where the largest number is "0" (e.g., when all numbers are zeros).
     *
     * @param nums The list of non-negative integers.
     * @return A string representing the largest number that can be formed by arranging the integers.
     */
    public String largestNumber(int[] nums) {
        // Convert the list of integers to a list of strings
        String[] numStrs = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // Sort the list of strings using a custom comparator
        Arrays.sort(numStrs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // Compare concatenated results in both possible orders
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // Sort in descending order
            }
        });

        // Join the sorted list of strings to form the largest number
        String result = String.join("", numStrs);

        // Handle the edge case where the largest number is "0"
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result;
    }

    public static void main(String[] args) {
        LargestNumber solver = new LargestNumber();

        // Test case 1
        int[] nums1 = {10, 2};
        System.out.println(solver.largestNumber(nums1)); // Output: "210"

        // Test case 2
        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println(solver.largestNumber(nums2)); // Output: "9534330"
    }
}