package Array.leetcodeQuestions;

import java.util.Arrays;

/**
 * This class provides a method to calculate the largest possible perimeter of a polygon
 * that can be formed from an array of integers.
 */
public class PolygonWithLargestPerimeter{

    /**
     * This method calculates the largest possible perimeter of a polygon that can be formed from an array of integers.
     * The method first sorts the array in ascending order. It then iterates over the array from the start to the end.
     * For each element, it checks if the element is less than the sum of the previous elements. If it is, it updates
     * the maximum perimeter found so far. The sum of the elements is also updated after each iteration.
     * If no such polygon can be formed, the method returns -1.
     *
     * @param nums an array of integers representing the lengths of the sides of potential polygons
     * @return the largest possible perimeter of a polygon that can be formed from the numbers in the array, or -1 if no such polygon can be formed
     */
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        long ans = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < sum) {
                ans = nums[i] + sum;
            }
            sum += nums[i];
        }

        return ans;
    }
}