package Array.leetcodeQuestions;

/**
 * This class provides a method to check if all 1's in a binary array are at least k places apart.
 */
public class CheckIfAll1s {

    /**
     * Checks if all 1's in the given binary array are at least k places apart.
     *
     * This method iterates through the array, tracking the index of the last 1 found.
     * If it encounters a 1 and the distance to the previous 1 is less than k, it returns false.
     * If no such case is found, it returns true, indicating all 1's are at least k places apart.
     *
     * @param nums The binary array to check, where each element is either 0 or 1.
     * @param k The minimum required distance between any two 1's in the array.
     * @return true if all 1's are at least k places apart, false otherwise.
     */
    public boolean kLengthApart(int[] nums, int k) {
        // Initialize the index of the previous 1 found in the array
        int prevIndex = -1;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is 1
            if (nums[i] == 1) {
                // If this is not the first 1 found and the distance to the previous 1 is less than k, return false
                if (prevIndex != -1 && i - prevIndex - 1 < k) {
                    return false;
                }
                // Update the index of the last 1 found
                prevIndex = i;
            }
        }

        // If no violations are found, return true
        return true;
    }
}