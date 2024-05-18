package Array.leetcodeQuestions;

/**
 * This class is used to solve the problem of finding the missing number in an array.
 * The array contains n distinct numbers in the range [0, n].
 */
public class MissinNumber {

    /**
     * This method finds and returns the missing number in the array.
     * It uses Gauss' formula to find the sum of the first n natural numbers and subtracts the sum of the array from it.
     * The difference is the missing number.
     *
     * @param nums The input array containing n distinct numbers in the range [0, n].
     * @return The missing number in the array.
     */
    public int missingNumber(int[] nums) {
        int n = nums.length; // The length of the array
        int totalSum = n * (n + 1) / 2; // The sum of the first n natural numbers
        int arraySum = 0; // The sum of the numbers in the array

        // Calculate the sum of the numbers in the array
        for (int num : nums) {
            arraySum += num;
        }

        // The missing number is the difference between the sum of the first n natural numbers and the sum of the array
        return totalSum - arraySum;
    }
}