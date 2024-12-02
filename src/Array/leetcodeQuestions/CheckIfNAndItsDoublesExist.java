package Array.leetcodeQuestions;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoublesExist {

    /**
     * Checks if there exist two indices i and j such that:
     * i != j
     * 0 <= i, j < arr.length
     * arr[i] == 2 * arr[j]
     *
     * @param arr the input array of integers
     * @return true if such indices exist, false otherwise
     */
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(2 * num) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        CheckIfNAndItsDoublesExist solution = new CheckIfNAndItsDoublesExist();

        int[] arr1 = {10, 2, 5, 3};
        System.out.println("Output (Test case 1): " + solution.checkIfExist(arr1)); // Expected output: true

        int[] arr2 = {3, 1, 7, 11};
        System.out.println("Output (Test case 2): " + solution.checkIfExist(arr2)); // Expected output: false
    }
}