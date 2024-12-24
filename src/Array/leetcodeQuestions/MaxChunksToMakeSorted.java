package Array.leetcodeQuestions;

public class MaxChunksToMakeSorted {

    /**
     * Returns the largest number of chunks we can make to sort the array.
     *
     * @param arr the input array representing a permutation of integers
     * @return the largest number of chunks
     */
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                chunks++;
            }
        }

        return chunks;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSorted solution = new MaxChunksToMakeSorted();

        int[] arr1 = {4, 3, 2, 1, 0};
        System.out.println("Max chunks (Test case 1): " + solution.maxChunksToSorted(arr1)); // Expected output: 1

        int[] arr2 = {1, 0, 2, 3, 4};
        System.out.println("Max chunks (Test case 2): " + solution.maxChunksToSorted(arr2)); // Expected output: 4
    }
}