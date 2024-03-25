package Array.leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a method to find all duplicates in an array.
 * The array is assumed to have n elements, all in the range [1, n], and each integer appears once or twice.
 */
public class DuplicatesInArray {

    /**
     * This method finds all duplicates in the input array.
     * It treats the integers in the array as indices and marks the corresponding elements as negative.
     * If an element is already negative when it tries to mark it, it means the integer has appeared before, so it adds it to the result.
     *
     * @param nums The input array of integers.
     * @return A list of integers that appear twice in the input array.
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Loop over the array
        for (int i = 0; i < nums.length; ++i) {
            // Calculate the index as the absolute value of the element minus 1
            int index = Math.abs(nums[i]) - 1;

            // If the element at the calculated index is negative, add the absolute value of the current element to the result
            if (nums[index] < 0) {
                result.add(Math.abs(nums[i]));
            }

            // Mark the element at the calculated index as negative
            nums[index] = -nums[index];
        }

        // Return the result
        return result;
    }
}