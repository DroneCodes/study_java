package leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    /**
     * The entry point of the program.
     * Calls the lexicalOrder method with a sample input and prints the result.
     *
     * @param args Command-line arguments (not used in this method).
     */
    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));
    }

    /**
     * Generates a list of integers from 1 to n in lexicographical order.
     * This method initializes the result list and starts the DFS traversal
     * for each number from 1 to 9.
     *
     * @param n The upper limit of the range of numbers to be generated.
     * @return A list of integers in lexicographical order.
     */
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            // Starts the DFS traversal for each number from 1 to 9
            dfs(i, n, result);
        }
        return result;
    }

    /**
     * A helper method that uses Depth-First Search (DFS) to generate numbers in lexicographical order.
     * This method recursively explores each number's "children" by appending digits from 0 to 9,
     * ensuring that numbers are added to the result list in lexicographical order.
     *
     * @param current The current number being processed.
     * @param n The upper limit of the range of numbers.
     * @param result The list that accumulates the results.
     */
    public static void dfs(int current, int n, List<Integer> result) {
        if (current > n) {
            return;
        }
        result.add(current);
        for (int i = 0; i < 10; i++) {
            if (10 * current + i > n) {
                return;
            }
            // Recursively calls dfs with the next number formed by appending the digit to the current number
            dfs(10 * current + i, n, result);
        }
    }
}