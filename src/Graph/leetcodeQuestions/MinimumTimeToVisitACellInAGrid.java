package Graph.leetcodeQuestions;

import java.util.PriorityQueue;
import java.util.Comparator;

public class MinimumTimeToVisitACellInAGrid {

    // Directions array representing the possible movements (right, left, down, up)
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * Finds the minimum time required to visit the bottom-right cell of the grid.
     *
     * @param grid the input grid where grid[row][col] represents the minimum time required to visit the cell
     * @return the minimum time required to visit the bottom-right cell, or -1 if it is not possible
     */
    public int minimumTime(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] seen = new boolean[rows][cols];

        pq.offer(new int[]{0, 0, 0}); // time, row, col
        seen[0][0] = true;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow >= rows ||
                        newCol < 0 || newCol >= cols ||
                        seen[newRow][newCol]) {
                    continue;
                }

                int newTime = time + 1;
                if (grid[newRow][newCol] > newTime) {
                    int wait = ((grid[newRow][newCol] - newTime + 1) / 2) * 2;
                    newTime += wait;
                }

                if (newRow == rows - 1 && newCol == cols - 1) {
                    return newTime;
                }

                seen[newRow][newCol] = true;
                pq.offer(new int[]{newTime, newRow, newCol});
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MinimumTimeToVisitACellInAGrid solution = new MinimumTimeToVisitACellInAGrid();

        int[][] grid1 = {
            {0, 1, 3, 2},
            {5, 1, 2, 5},
            {4, 3, 8, 6}
        };
        System.out.println("Minimum time to visit bottom-right cell (Test case 1): " + solution.minimumTime(grid1)); // Expected output: 7

        int[][] grid2 = {
            {0, 2, 4},
            {3, 2, 1},
            {1, 0, 4}
        };
        System.out.println("Minimum time to visit bottom-right cell (Test case 2): " + solution.minimumTime(grid2)); // Expected output: -1
    }
}