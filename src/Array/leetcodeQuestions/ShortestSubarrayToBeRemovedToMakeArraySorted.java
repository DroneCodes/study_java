package Array.leetcodeQuestions;

public class ShortestSubarrayToBeRemovedToMakeArraySorted {

    /**
     * Finds the length of the shortest subarray that can be removed to make the remaining array non-decreasing.
     *
     * @param arr the input array of integers
     * @return the length of the shortest subarray to remove
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        // Find the longest non-decreasing prefix
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        // If the entire array is non-decreasing, return 0
        if (left == n - 1) {
            return 0;
        }

        // Find the longest non-decreasing suffix
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        // Calculate the minimum length to remove
        int minLength = Math.min(n - left - 1, right);

        // Try to merge the prefix and suffix
        int i = 0;
        int j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                minLength = Math.min(minLength, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        ShortestSubarrayToBeRemovedToMakeArraySorted solution = new ShortestSubarrayToBeRemovedToMakeArraySorted();

        int[] arr1 = {1, 2, 3, 10, 4, 2, 3, 5};
        System.out.println(solution.findLengthOfShortestSubarray(arr1)); // Output: 3

        int[] arr2 = {5, 4, 3, 2, 1};
        System.out.println(solution.findLengthOfShortestSubarray(arr2)); // Output: 4

        int[] arr3 = {1, 2, 3};
        System.out.println(solution.findLengthOfShortestSubarray(arr3)); // Output: 0
    }
}