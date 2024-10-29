package Array.leetcodeQuestions;

/**
 * This class provides a method to find the maximum number of moves in a grid.
 * You can start at any cell in the first column and move to cells in the next column
 * with a strictly greater value.
 */
public class MaximumNumberOfMovesInAGrid {

    /**
     * Finds the maximum number of moves that can be performed in the grid.
     *
     * The movement rules are:
     * - From a cell (row, col), you can move to any of the cells:
     *   (row - 1, col + 1), (row, col + 1), and (row + 1, col + 1)
     * - The value of the cell you move to must be strictly greater than the value of the current cell.
     *
     * @param grid the 2D array of positive integers representing the grid
     * @return the maximum number of moves that can be performed
     */
    public int maxMoves(int[][] grid) {
        int m = grid.length; // number of rows
        int n = grid[0].length; // number of columns
        int[][] dp = new int[m][n]; // DP table to store the maximum number of moves from each cell

        // Initialize the first column of the DP table with 0 moves
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }

        // Fill the DP table
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                dp[i][j] = -1; // Initialize with -1 to indicate no valid move
                // Check the possible moves and update the DP table
                if (i > 0 && grid[i][j] > grid[i-1][j-1] && dp[i-1][j-1] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
                if (grid[i][j] > grid[i][j-1] && dp[i][j-1] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + 1);
                }
                if (i < m - 1 && grid[i][j] > grid[i+1][j-1] && dp[i+1][j-1] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i+1][j-1] + 1);
                }
            }
        }

        // Find the maximum value in the last column of the DP table
        int maxMoves = 0;
        for (int i = 0; i < m; i++) {
            maxMoves = Math.max(maxMoves, dp[i][n-1]);
        }

        return maxMoves;
    }
}