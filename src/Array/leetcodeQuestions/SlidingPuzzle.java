package Array.leetcodeQuestions;

import java.util.*;

public class SlidingPuzzle {

    /**
     * Solves the sliding puzzle and returns the least number of moves required to solve the board.
     *
     * @param board the input 2 x 3 board
     * @return the least number of moves required to solve the board, or -1 if it is impossible
     */
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = Arrays.deepToString(board).replaceAll("[\\[\\], ]", "");

        int[][] neighbors = {
            {1, 3},    // neighbors of index 0
            {0, 2, 4}, // neighbors of index 1
            {1, 5},    // neighbors of index 2
            {0, 4},    // neighbors of index 3
            {1, 3, 5}, // neighbors of index 4
            {2, 4}     // neighbors of index 5
        };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return moves;
                }

                int zeroIndex = current.indexOf('0');
                for (int neighbor : neighbors[zeroIndex]) {
                    String next = swap(current, zeroIndex, neighbor);
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    /**
     * Swaps two characters in a string and returns the new string.
     *
     * @param s the input string
     * @param i the index of the first character
     * @param j the index of the second character
     * @return the new string with the characters swapped
     */
    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    /**
     * Main method to test the slidingPuzzle method with different examples.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SlidingPuzzle solution = new SlidingPuzzle();

        int[][] board1 = {{1, 2, 3}, {4, 0, 5}};
        System.out.println(solution.slidingPuzzle(board1)); // Output: 1

        int[][] board2 = {{1, 2, 3}, {5, 4, 0}};
        System.out.println(solution.slidingPuzzle(board2)); // Output: -1

        int[][] board3 = {{4, 1, 2}, {5, 0, 3}};
        System.out.println(solution.slidingPuzzle(board3)); // Output: 5
    }
}