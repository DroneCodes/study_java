package Array.leetcodeQuestions;

import java.util.HashSet;
import java.util.Set;

/**
 * The MaxIntegersChoosed class provides a method to determine the maximum number of integers
 * that can be chosen from a range [1, n] without exceeding a given sum and avoiding banned numbers.
 */
public class MaxIntegersChoosed {

    /**
     * Returns the maximum number of integers that can be chosen following the rules.
     *
     * @param banned the array of banned integers
     * @param n the upper limit of the range [1, n]
     * @param maxSum the maximum allowed sum of chosen integers
     * @return the maximum number of integers that can be chosen
     */
    public int maxCount(int[] banned, int n, int maxSum) {
        // Create a set of banned numbers for quick lookup
        Set<Integer> bannedNumbers = new HashSet<>();
        for (int num : banned) {
            bannedNumbers.add(num);
        }

        int result = 0; // Count of chosen integers
        int sum = 0;    // Sum of chosen integers

        // Iterate through the range [1, n]
        for (int i = 1; i <= n; i++) {
            // Check if the number is not banned and adding it does not exceed maxSum
            if (!bannedNumbers.contains(i) && sum + i <= maxSum) {
                sum += i; // Add the number to the sum
                result++; // Increment the count of chosen integers
            }
        }

        return result; // Return the count of chosen integers
    }
}