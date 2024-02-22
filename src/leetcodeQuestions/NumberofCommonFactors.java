package leetcodeQuestions;

/**
 * This class provides a method to find the number of common factors of two positive integers.
 */
public class NumberofCommonFactors {

/**
 *
     * To solve this problem, we can follow these steps:
     * Find the minimum of a and b.
     * Iterate from 1 to the minimum number.
     * For each number, check if it is a factor of both a and b. If it is, increment a counter.
     * Return the counter.
     *
     *  Time Complexity: O(min(a, b))
     *  Space Complexity: O(1)
     *
     * This method returns the number of common factors of two positive integers.
     *
     * @param a The first positive integer.
     * @param b The second positive integer.
     * @return The number of common factors of a and b.
     */
    public static int commonFactors(int a, int b) {
        int min = Math.min(a, b);
        int count = 0;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * The main method that tests the commonFactors method with sample inputs.
     *
     * @param args The command line arguments. Not used in this method.
     */
    public static void main(String[] args) {
        System.out.println(commonFactors(12, 6));  // Output: 4
        System.out.println(commonFactors(25, 30)); // Output: 2
    }
}