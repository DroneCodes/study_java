package Array.leetcodeQuestions;

public class MaximumMatrixSum {

    /**
     * Maximizes the sum of the matrix's elements using the given operation.
     *
     * @param matrix the input n x n integer matrix
     * @return the maximum sum of the matrix's elements
     */
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int negativeCount = 0;
        int minAbsValue = Integer.MAX_VALUE;

        // Calculate the initial sum, count negative elements, and find the smallest absolute value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.abs(matrix[i][j]);
                if (matrix[i][j] < 0) {
                    negativeCount++;
                }
                minAbsValue = Math.min(minAbsValue, Math.abs(matrix[i][j]));
            }
        }

        // If the number of negative elements is odd, subtract twice the smallest absolute value
        if (negativeCount % 2 != 0) {
            sum -= 2 * minAbsValue;
        }

        return sum;
    }

    /**
     * Main method to test the maxMatrixSum method with different examples.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        MaximumMatrixSum solution = new MaximumMatrixSum();

        int[][] matrix1 = {{1, -1}, {-1, 1}};
        System.out.println(solution.maxMatrixSum(matrix1)); // Output: 4

        int[][] matrix2 = {{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}};
        System.out.println(solution.maxMatrixSum(matrix2)); // Output: 16
    }
}