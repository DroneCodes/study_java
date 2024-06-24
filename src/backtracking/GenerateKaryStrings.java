package backtracking;

/**
 * This class provides a solution for generating all strings of length n drawn from 0...k - 1.
 */
public class GenerateKaryStrings {

    /**
     * This method initializes the process of generating all strings of length n drawn from 0...k - 1.
     *
     * @param n The length of the strings to be generated.
     * @param k The range of numbers to be used in the strings (0...k - 1).
     */
    void generateKaryStrings(int n, int k) {
        char[] arr = new char[n];
        generateKaryStrings(arr, 0, n, k);
    }

    /**
     * This method generates all strings of length n drawn from 0...k - 1 using recursion.
     *
     * @param arr The array used to build the strings.
     * @param i The current index in the array.
     * @param n The length of the strings to be generated.
     * @param k The range of numbers to be used in the strings (0...k - 1).
     */
    void generateKaryStrings(char[] arr, int i, int n, int k) {
        if (i == n) {
            System.out.println(new String(arr));
            return;
        }

        for (int j = 0; j < k; j++) {
            arr[i] = (char) ('0' + j);
            generateKaryStrings(arr, i + 1, n, k);
        }
    }

    /**
     * The main method for testing the generateKaryStrings method.
     *
     * @param args The command-line arguments. Not used in this method.
     */
    public static void main(String[] args) {
        GenerateKaryStrings gks = new GenerateKaryStrings();
        gks.generateKaryStrings(3, 3);  // Change these values as needed
    }
}