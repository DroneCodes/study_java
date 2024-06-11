package Strings.leetcodeQuestions;

/**
 * This class contains methods to check if one string is a rotation of another.
 */
public class RotateString {

    /**
     * This method checks if s2 is a rotation of a substring of s1.
     *
     * @param s1 The original string.
     * @param s2 The string to check if it is a rotation of a substring of s1.
     * @return true if s2 is a rotation of a substring of s1, false otherwise.
     */
    boolean checkRotation(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Iterate over the length of s1 - length of s2 + 1
        for (int i = 0; i < (m - n + 1); i++) {
            // Iterate over the length of s2
            for (int j = 0; j < n; j++) {
                // If characters at current indices do not match, break the inner loop
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    break;
                }
                // If we have iterated over the entire length of s2, return true
                if (j == n - 1) {
                    return true;
                }
            }
        }
        // If no rotation found, return false
        return false;
    }

    /**
     * This method checks if s2 is a rotation of s1.
     *
     * @param s1 The original string.
     * @param s2 The string to check if it is a rotation of s1.
     * @return true if s2 is a rotation of s1, false otherwise.
     */
    boolean isRotation(String s1, String s2) {

        // Check if s1 and s2 are the same length, if not return false
        if (s1.length() != s2.length()) {
            return false;
        }

        // Check if s1 and s2 are the same, if so return false
        if (s1.equals(s2)) {
            return false;
        }

        // Concatenate s1 with itself
        String temp = s1 + s1;

        // Check if s2 is a rotation of the concatenated string
        return checkRotation(temp, s2);
    }
}