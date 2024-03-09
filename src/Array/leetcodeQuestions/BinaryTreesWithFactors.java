package Array.leetcodeQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/*
- Sort the input array in ascending order to facilitate the calculations.
- Create a memo map to store the number of binary trees that can be formed for each number. The key is the number, and the value is the count of trees.
- Initialize totalTrees to 0. This variable will accumulate the total count of binary trees.
- Iterate through the array to compute the number of trees for each number.
- For each number in the array, start with the assumption that it can form at least one tree by itself.
- Try to find factors of the current number in the array.
- If a factor is found (i.e., arr[i] % arr[j] == 0), calculate the complement of the factor.
- If the complement exists in the memoization map, it means that the factor and its complement can form binary trees. Multiply the counts of the factor and complement trees and add this to the numTrees for the current number.
- Store the result in the memo map for the current number.
- Accumulate the count of trees in the totalTrees variable, taking care to keep the result modulo 10^9 + 7 to avoid overflow.
- Finally, return the totalTrees as the total number of binary trees that can be formed.
 */

public class BinaryTreesWithFactors {

    private static final int MOD = 1_000_000_007;
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr); // Sort the input array in ascending order
        int n = arr.length;

        // Create a HashMap to store the result for each number
        Map<Integer, Long> memo = new HashMap<>();

        long totalTrees = 0;

        // Iterate through the array to compute the number of trees for each number
        for (int i = 0; i < n; i++) {
            long numTrees = 1; // Each number can form at least one tree by itself

            // Try to find factors for the current number
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int complement = arr[i] / arr[j];
                    if (memo.containsKey(complement)) {
                        // If the complement exists in the memoization map, multiply the count
                        numTrees = (numTrees + memo.get(arr[j]) * memo.get(complement)) % MOD;
                    }
                }
            }

            // Store the result for the current number in the memoization map
            memo.put(arr[i], numTrees);

            // Accumulate the count of trees
            totalTrees = (totalTrees + numTrees) % MOD;
        }

        return (int) totalTrees;
    }
}
