package Array.leetcodeQuestions;

/**
 * The WordSearch class is a solution for the Word Search problem.
 * The problem is about finding if a given word can be formed by traversing a 2D grid of characters.
 * The traversal can be done horizontally or vertically, and each cell can be used only once.
 *
 * The class contains a static 2D array DIRECTIONS that represents the four possible directions for traversal: up, down, left, and right.
 * The exist method is the entry point for the solution. It takes a 2D character array board and a word as input.
 * It first checks if the board is null or empty. If it is, the method returns false.
 * Then, it creates a 2D boolean array visited of the same size as the board to keep track of the cells that have been visited.
 * It then iterates over each cell in the board and calls the dfs method.
 *
 * The dfs method performs a depth-first search on the board. It takes the board, the word, the current index in the word,
 * the current cell coordinates, and the visited array as input.
 * If the current index equals the length of the word, it means the word has been found and the method returns true.
 * If the current cell is out of bounds, has been visited before, or its character does not match the current character in the word,
 * the method returns false. Otherwise, it marks the current cell as visited and continues the search in the four possible directions.
 * If the word is found, the method returns true. If not, it backtracks by marking the current cell as not visited and returns false.
 */
public class WordSearch {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }
        visited[x][y] = true;
        for (int[] dir : DIRECTIONS) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (dfs(board, word, index + 1, newX, newY, visited)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }


    /**
     * This method is an optimized version of the exist method.
     * It uses the same depth-first search approach but stops the search as soon as the word is found.
     * This can make the search faster on larger boards.
     */
    public boolean existFaster(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfsFaster(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method is an optimized version of the dfs method.
     * It performs a depth-first search on the board and stops the search as soon as the word is found.
     */
    private boolean dfsFaster(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }
        visited[x][y] = true;
        for (int[] dir : DIRECTIONS) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (dfsFaster(board, word, index + 1, newX, newY, visited)) {
                return true;  // return immediately if the word is found
            }
        }
        visited[x][y] = false;
        return false;
    }
}


