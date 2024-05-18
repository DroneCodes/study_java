package leetcodeQuestions;

/**
 * This class is used to solve the problem of finding the bitwise AND of all numbers in a given range.
 * The range is defined by two integers, m and n.
 */
public class BitwiseAnd {

    /**
     * This method calculates and returns the bitwise AND of all numbers in the range [m, n].
     * It uses a bitwise shift operation to find the common prefix of m and n in their binary representation.
     * The common prefix is then shifted back to its original position to get the result.
     *
     * @param m The start of the range.
     * @param n The end of the range.
     * @return The bitwise AND of all numbers in the range [m, n].
     */
    public static int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }

    /**
     * The main method which is the entry point for the program.
     * It tests the rangeBitwiseAnd method with some test cases.
     *
     * @param args The command-line arguments for the program.
     */
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7)); // Expected output: 4
        System.out.println(rangeBitwiseAnd(0, 1)); // Expected output: 0
    }
}