package backtracking;

/**
 * This class provides a solution for generating all binary strings of a given length.
 */
public class BinaryStrings {

    /**
     * This method generates all binary strings of a given length using recursion.
     *
     * @param n The length of the binary strings to be generated.
     * @param str The binary string generated so far. Initially, this should be an empty string.
     */
    public void binaryString(int n, String str) {
        // Base case: if n is less than 1, print the generated string and return.
        if(n < 1) {
            System.out.println(str);
            return;
        }
        // Recursive case: generate binary strings by appending 0 and 1 to the current string.
        binaryString(n-1, str + "0");
        binaryString(n-1, str + "1");
    }

    /**
     * The main method for testing the binaryString method.
     *
     * @param args The command-line arguments. Not used in this method.
     */
    public static void main(String[] args) {
        BinaryStrings obj = new BinaryStrings();
        // Test the binaryString method with n = 3.
        obj.binaryString(2, "");

        // 1001
    }
}