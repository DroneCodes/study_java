package Array.leetcodeQuestions;

import java.util.HashMap;
import java.util.Map;

public class FlipCoinsForMaximumNumberOfEqualRows {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            int firstElement = row[0];
            for (int element : row) {
                pattern.append(element ^ firstElement);
            }
            String patternStr = pattern.toString();
            patternCount.put(patternStr, patternCount.getOrDefault(patternStr, 0) + 1);
        }

        int maxRows = 0;
        for (int count : patternCount.values()) {
            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }

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