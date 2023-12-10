package Arrays.leetcodeQuestions;

public class TransposeMatrix {

    public static int[][] transpose(int[][] matrix) {
        // Create a new 2D array with the number of rows and columns swapped
        int[][] result = new int[matrix[0].length][matrix.length];
        // Iterate over each element in the original matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // Assign the value of the current element to the corresponding position in the transposed matrix
                result[j][i] = matrix[i][j];
            }
        }
        // Return the transposed matrix
        return result;
    }

    public static void main(String[] args) {
        // Create a 2D array to represent the matrix
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        // Call the transpose method and print the result
        int[][] transposedMatrix = transpose(matrix);
        for (int[] row : transposedMatrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}