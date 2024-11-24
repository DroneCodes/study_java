package Array.leetcodeQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a method to find the maximum number of rows that have all values equal after flipping columns.
 */
public class FlipCoinsForMaximumNumberOfEqualRows {

    /**
     * Finds the maximum number of rows that have all values equal after flipping columns.
     *
     * @param matrix the input binary matrix
     * @return the maximum number of rows with all values equal after flips
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();

        // Iterate through each row in the matrix
        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            int firstElement = row[0];
            // Normalize the row by flipping it if the first element is 1
            for (int element : row) {
                pattern.append(element ^ firstElement);
            }
            String patternStr = pattern.toString();
            // Update the frequency of the normalized row pattern
            patternCount.put(patternStr, patternCount.getOrDefault(patternStr, 0) + 1);
        }

        int maxRows = 0;
        // Find the maximum frequency of any pattern
        for (int count : patternCount.values()) {
            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }

    /**
     * Main method to test the maxEqualRowsAfterFlips method with different examples.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        FlipCoinsForMaximumNumberOfEqualRows solution = new FlipCoinsForMaximumNumberOfEqualRows();

        int[][] matrix1 = {{0, 1}, {1, 1}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix1)); // Output: 1

        int[][] matrix2 = {{0, 1}, {1, 0}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix2)); // Output: 2

        int[][] matrix3 = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix3)); // Output: 2
    }
}