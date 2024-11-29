package Graph.leetcodeQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumObstacleRemovalToReachCorner {
    // Directions array representing the possible movements (right, left, down, up)
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // Dynamic programming array to store the minimum number of obstacles to be removed to reach each cell
    private int[][] dp = null;

    /**
     * Finds the minimum number of obstacles that need to be removed to reach the bottom-right corner of the grid.
     *
     * @param grid the input grid where 0 represents an empty cell and 1 represents an obstacle
     * @return the minimum number of obstacles to be removed
     */
    public int minimumObstacles(int[][] grid) {
        int m = grid.length; // Number of rows in the grid
        int n = grid[0].length; // Number of columns in the grid
        dp = new int[m][n]; // Initialize the dp array with the same dimensions as the grid

        // Fill the dp array with a large value (infinity) to represent unvisited cells
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        // The starting cell (0,0) has an initial cost equal to its value in the grid
        dp[0][0] = grid[0][0];

        // Priority queue to store the cells to be processed, ordered by the current cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(a -> a[2])));
        pq.offer(new int[]{dp[0][0], 0, 0}); // Add the starting cell to the priority queue

        // Process the cells in the priority queue
        while (!pq.isEmpty()) {
            int[] curr = pq.poll(); // Get the cell with the lowest cost
            int x = curr[0]; // Current cell's row index
            int y = curr[1]; // Current cell's column index
            int currCost = curr[2]; // Current cost to reach this cell

            // If the bottom-right corner is reached, return the current cost
            if (x == m - 1 && y == n - 1) {
                return currCost;
            }

            // Explore the neighboring cells
            for (int[] d : directions) {
                int nextX = x + d[0]; // Row index of the neighboring cell
                int nextY = y + d[1]; // Column index of the neighboring cell

                // Check if the neighboring cell is within the grid bounds and if the new cost is lower
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && currCost + grid[nextX][nextY] < dp[nextX][nextY]) {
                    dp[nextX][nextY] = currCost + grid[nextX][nextY]; // Update the cost to reach the neighboring cell
                    pq.offer(new int[]{nextX, nextY, dp[nextX][nextY]}); // Add the neighboring cell to the priority queue
                }
            }
        }

        // Return the cost to reach the bottom-right corner
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MinimumObstacleRemovalToReachCorner solution = new MinimumObstacleRemovalToReachCorner();

        // Test case 1
        int[][] grid1 = {
                {0, 1, 1},
                {1, 1, 0},
                {1, 0, 0}
        };
        System.out.println("Minimum obstacles to remove (Test case 1): " + solution.minimumObstacles(grid1)); // Expected output: 2

        // Test case 2
        int[][] grid2 = {
                {0, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 0, 0, 0},
                {1, 1, 1, 0}
        };
        System.out.println("Minimum obstacles to remove (Test case 2): " + solution.minimumObstacles(grid2)); // Expected output: 2

        // Test case 3
        int[][] grid3 = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println("Minimum obstacles to remove (Test case 3): " + solution.minimumObstacles(grid3)); // Expected output: 0
    }
}
