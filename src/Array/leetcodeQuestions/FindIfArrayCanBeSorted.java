package Array.leetcodeQuestions;

public class FindIfArrayCanBeSorted {

    /**
     * Checks if the array can be sorted by swapping adjacent elements with the same number of set bits.
     *
     * @param nums The input array of integers.
     * @return True if the array can be sorted, otherwise false.
     */
    public boolean canSortArray(int[] nums) {
        int[] bitCounts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            bitCounts[i] = countSetBits(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (isSorted(nums)) {
                return true;
            }
            for (int j = 1; j < nums.length; j++) {
                if (bitCounts[j] == bitCounts[j - 1] && nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
        return false;
    }

    /**
     * Counts the number of set bits in the binary representation of a number.
     *
     * @param n The input number.
     * @return The number of set bits.
     */
    private int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    /**
     * Checks if the array is sorted in non-decreasing order.
     *
     * @param arr The input array.
     * @return True if the array is sorted, otherwise false.
     */
    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Swaps two elements in an array.
     *
     * @param arr The input array.
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}