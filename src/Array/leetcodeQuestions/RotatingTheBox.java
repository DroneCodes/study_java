package Array.leetcodeQuestions;

/**
 * This class provides a method to rotate a box 90 degrees clockwise and apply gravity to the stones.
 */
public class RotatingTheBox {

    /**
     * Rotates the box 90 degrees clockwise and applies gravity to the stones.
     *
     * @param box the input m x n matrix representing the box
     * @return the n x m matrix representing the box after rotation and gravity
     */
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] rotatedBox = new char[n][m];

        // Rotate the box 90 degrees clockwise
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - 1 - i] = box[i][j];
            }
        }

        // Apply gravity to the stones in the rotated box
        for (int j = 0; j < m; j++) {
            int emptyRow = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (rotatedBox[i][j] == '*') {
                    emptyRow = i - 1;
                } else if (rotatedBox[i][j] == '#') {
                    rotatedBox[i][j] = '.';
                    rotatedBox[emptyRow][j] = '#';
                    emptyRow--;
                }
            }
        }

        return rotatedBox;
    }

    /**
     * Main method to test the rotateTheBox method with different examples.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        RotatingTheBox solution = new RotatingTheBox();

        char[][] box1 = {{'#', '.', '#'}};
        char[][] result1 = solution.rotateTheBox(box1);
        for (char[] row : result1) {
            System.out.println(java.util.Arrays.toString(row));
        }

        char[][] box2 = {
            {'#', '.', '*', '.'},
            {'#', '#', '*', '.'}
        };
        char[][] result2 = solution.rotateTheBox(box2);
        for (char[] row : result2) {
            System.out.println(java.util.Arrays.toString(row));
        }

        char[][] box3 = {
            {'#', '#', '*', '.', '*', '.'},
            {'#', '#', '#', '*', '.', '.'},
            {'#', '#', '#', '.', '#', '.'}
        };
        char[][] result3 = solution.rotateTheBox(box3);
        for (char[] row : result3) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}