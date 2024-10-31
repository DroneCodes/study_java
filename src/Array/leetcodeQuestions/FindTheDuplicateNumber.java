package Array.leetcodeQuestions;

/**
 * This class provides a method to find the duplicate number in an array.
 * The array contains n+1 integers where each integer is between 1 and n (inclusive).
 */
public class FindTheDuplicateNumber {

    /**
     * Finds the duplicate number in an array where each integer is between 1 and n (inclusive).
     *
     * The method uses the array indices to mark visited numbers by negating the value at the index
     * corresponding to the current number. If a number is encountered whose corresponding index
     * already has a negative value, it means the number is a duplicate.
     *
     * @param nums the input array containing n+1 integers
     * @return the duplicate number, or -1 if no duplicate is found
     */
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) {
                return index;
            } else {
                nums[index] = -nums[index];
            }
        }
        return -1;
    }
}