package Recursions.leetcodeQuestions;

/**
 * This class provides a solution for checking if an array is sorted in ascending order.
 */
public class SortArray {

    /**
     * This method checks if an array is sorted in ascending order using recursion.
     *
     * @param arr The array to be checked.
     * @param index The index to start checking from. Initially, this should be the length of the array.
     * @return 1 if the array is sorted, 0 otherwise.
     *
     * Time Complexity: O(n)
     */
    public int isArrayInSortedOrder(int[] arr, int index) {
        // Base case: if the index is 1, the array is sorted.
        if(index == 1 || index == 0) {
            return 1;
        }
        // Recursive case: check if the current element is less than the previous one.
        // If it is, return 0 (array is not sorted). Otherwise, check the next pair of elements.
        return (arr[index - 1] < arr[index - 2] ? 0 : isArrayInSortedOrder(arr, index - 1));
    }

    public static void main(String[] args) {
        SortArray obj = new SortArray();
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(obj.isArrayInSortedOrder(arr, arr.length));
    }
}