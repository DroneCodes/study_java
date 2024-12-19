package Array.leetcodeQuestions;

/**
 * This class provides a method to find the final state of an integer array after performing a specified number of operations.
 */
public class FindArrayStateAfterKMultiplication {

    /**
     * This method performs k operations on the given integer array nums.
     * In each operation, it finds the minimum value in the array and multiplies it by the given multiplier.
     *
     * @param nums The integer array to be modified.
     * @param k The number of operations to be performed.
     * @param multiplier The multiplier to be used in each operation.
     * @return The final state of the integer array after performing all k operations.
     */
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int smallest = 0;
            // Find the index of the smallest value in the array
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[smallest]) {
                    smallest = j;
                }
            }
            // Multiply the smallest value by the multiplier
            nums[smallest] *= multiplier;
        }
        return nums;
    }
}