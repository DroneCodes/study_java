package Array.leetcodeQuestions;

/**
 * This class provides a method to decrypt a circular array based on a given integer k.
 */
public class DefuseTheBomb {

    /**
     * Decrypts the given code array based on the value of k.
     *
     * @param code the input array representing the circular code
     * @param k the integer value used to determine the decryption method
     * @return the decrypted array
     */
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        // If k is 0, return an array of zeros
        if (k == 0) {
            return result;
        }

        // Iterate through each element in the code array
        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                // Sum the next k elements in the circular array
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }
            } else {
                // Sum the previous k elements in the circular array
                for (int j = -1; j >= k; j--) {
                    sum += code[(i + n + j) % n];
                }
            }
            result[i] = sum;
        }

        return result;
    }
}