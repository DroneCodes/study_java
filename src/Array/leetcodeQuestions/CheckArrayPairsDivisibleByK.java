package Array.leetcodeQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * The CheckArrayPairsDivisibleByK class provides a method to check if an array can be divided into pairs
 * such that the sum of each pair is divisible by a given integer k.
 */
public class CheckArrayPairsDivisibleByK {

    /**
     * Checks if the array can be divided into pairs such that the sum of each pair is divisible by k.
     *
     * @param arr the array of integers
     * @param k the integer by which the sum of each pair should be divisible
     * @return true if the array can be divided into pairs with the required property, false otherwise
     */
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();

        // Populate the remainder count map
        for (int num : arr) {
            int remainder = ((num % k) + k) % k; // Handle negative numbers
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        // Check if pairs can be formed
        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            if (remainder == 0) {
                // For remainder 0, count must be even
                if (remainderCount.get(remainder) % 2 != 0) {
                    return false;
                }
            } else {
                // For other remainders, count of remainder and k - remainder must be equal
                int complement = k - remainder;
                if (!remainderCount.get(remainder).equals(remainderCount.get(complement))) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Main method to demonstrate the usage of the CheckArrayPairsDivisibleByK class.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        CheckArrayPairsDivisibleByK solution = new CheckArrayPairsDivisibleByK();
        int[] arr1 = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k1 = 5;
        System.out.println(solution.canArrange(arr1, k1)); // Output: true

        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int k2 = 7;
        System.out.println(solution.canArrange(arr2, k2)); // Output: true

        int[] arr3 = {1, 2, 3, 4, 5, 6};
        int k3 = 10;
        System.out.println(solution.canArrange(arr3, k3)); // Output: false
    }
}