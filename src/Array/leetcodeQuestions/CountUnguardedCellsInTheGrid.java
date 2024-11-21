package Array.leetcodeQuestions;

/**
 * This class provides a method to count the number of unoccupied cells that are not guarded in a grid.
 */
public class CountUnguardedCellsInTheGrid {

    /**
     * Counts the number of unoccupied cells that are not guarded in a grid.
     *
     * @param m the number of rows in the grid
     * @param n the number of columns in the grid
     * @param guards a 2D array representing the positions of the guards
     * @param walls a 2D array representing the positions of the walls
     * @return the number of unoccupied cells that are not guarded
     */
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];

        // Mark guards and walls on the grid
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 'G';
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 'W';
        }

        // Mark the cells guarded by each guard
        for (int[] guard : guards) {
            markGuardedCells(grid, guard[0], guard[1], m, n);
        }

        // Count unguarded cells
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '\0') {
                    unguardedCount++;
                }
            }
        }

        return unguardedCount;
    }

    /**
     * Marks the cells that are guarded by a guard in the four cardinal directions.
     *
     * @param grid the grid representing the state of each cell
     * @param row the row position of the guard
     * @param col the column position of the guard
     * @param m the number of rows in the grid
     * @param n the number of columns in the grid
     */
    private void markGuardedCells(char[][] grid, int row, int col, int m, int n) {
        // Mark cells in the north direction
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == 'W' || grid[i][col] == 'G') break;
            grid[i][col] = 'X';
        }
        // Mark cells in the south direction
        for (int i = row + 1; i < m; i++) {
            if (grid[i][col] == 'W' || grid[i][col] == 'G') break;
            grid[i][col] = 'X';
        }
        // Mark cells in the west direction
        for (int j = col - 1; j >= 0; j--) {
            if (grid[row][j] == 'W' || grid[row][j] == 'G') break;
            grid[row][j] = 'X';
        }
        // Mark cells in the east direction
        for (int j = col + 1; j < n; j++) {
            if (grid[row][j] == 'W' || grid[row][j] == 'G') break;
            grid[row][j] = 'X';
        }
    }

    /**
     * Main method to test the countUnguarded method with different examples.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        CountUnguardedCellsInTheGrid solution = new CountUnguardedCellsInTheGrid();

        int m1 = 4, n1 = 6;
        int[][] guards1 = {{0, 0}, {1, 1}, {2, 3}};
        int[][] walls1 = {{0, 1}, {2, 2}, {1, 4}};
        System.out.println(solution.countUnguarded(m1, n1, guards1, walls1)); // Output: 7

        int m2 = 3, n2 = 3;
        int[][] guards2 = {{1, 1}};
        int[][] walls2 = {{0, 1}, {1, 0}, {2, 1}, {1, 2}};
        System.out.println(solution.countUnguarded(m2, n2, guards2, walls2)); // Output: 4
    }
}