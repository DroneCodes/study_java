package Array.leetcodeQuestions;

public class FindTheDuplicateNumber {

    /**
     * Finds the duplicate number in an array where each integer is between 1 and n (inclusive).
     *
     * @param nums the input array containing n+1 integers
     * @return the duplicate number
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
