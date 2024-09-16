package Array.leetcodeQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExit {
    /**
     * Finds the nearest exit from the entrance in the given maze.
     * <p>
     * This method uses the Breadth-First Search (BFS) algorithm to find the shortest path
     * from the entrance to the nearest exit in a maze. The maze is represented as a 2D array
     * where '.' represents an empty cell and '+' represents a wall. The entrance is given
     * as an array of two integers representing the row and column of the entrance cell.
     *
     * @param maze     A 2D array representing the maze, where '.' represents an empty cell and '+' represents a wall.
     * @param entrance An array of two integers representing the row and column of the entrance cell.
     * @return The number of steps in the shortest path to the nearest exit, or -1 if no such path exists.
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], steps = current[2];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == '.' && !visited[newX][newY]) {
                    if (newX == 0 || newX == m - 1 || newY == 0 || newY == n - 1) {
                        return steps + 1;
                    }
                    queue.offer(new int[]{newX, newY, steps + 1});
                    visited[newX][newY] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NearestExit solver = new NearestExit();
        char[][] maze1 = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        int[] entrance1 = {1, 2};
        System.out.println(solver.nearestExit(maze1, entrance1)); // Output: 1

        char[][] maze2 = {{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
        int[] entrance2 = {1, 0};
        System.out.println(solver.nearestExit(maze2, entrance2)); // Output: 2

        char[][] maze3 = {{'.', '+'}};
        int[] entrance3 = {0, 0};
        System.out.println(solver.nearestExit(maze3, entrance3)); // Output: -1
    }
}
