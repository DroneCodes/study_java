package Array.leetcodeQuestions;

/**
 * This class contains a method to sort an array relative to another array.
 */
public class RelativeSortArray {

    /**
     * This method sorts the elements of the first array based on the order defined by the second array.
     * Elements of the first array that are not found in the second array are placed at the end of the first array in ascending order.
     *
     * @param arr1 The first array to be sorted.
     * @param arr2 The second array that defines the order.
     * @return The sorted first array.
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Create a count array to count the occurrence of each number in arr1
        int[] count = new int[1001];
        for (int i : arr1) {
            count[i]++;
        }

        int i = 0;
        // Iterate over arr2, for each number in arr2, place it in arr1 for the number of times it occurs
        for (int j : arr2) {
            while (count[j]-- > 0) {
                arr1[i++] = j;
            }
        }

        // For the numbers in arr1 that are not in arr2, place them in the remaining positions of arr1 in ascending order
        for (int j = 0; j < count.length; j++) {
            while (count[j]-- > 0) {
                arr1[i++] = j;
            }
        }

        // Return the sorted arr1
        return arr1;
    }
}