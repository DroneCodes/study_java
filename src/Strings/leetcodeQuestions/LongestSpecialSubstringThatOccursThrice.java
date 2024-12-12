package Strings.leetcodeQuestions;

import java.util.HashMap;
import java.util.Map;

public class LongestSpecialSubstringThatOccursThrice {

    /**
     * Returns the length of the longest special substring that occurs at least thrice.
     *
     * @param s the input string
     * @return the length of the longest special substring that occurs at least thrice, or -1 if no such substring exists
     */
    public int longestSpecialSubstring(String s) {
        int n = s.length();
        int maxLength = -1;

        // Iterate through all possible lengths of special substrings
        for (int len = 1; len <= n; len++) {
            Map<String, Integer> substringCount = new HashMap<>();

            // Iterate through all substrings of the current length
            for (int i = 0; i <= n - len; i++) {
                String substring = s.substring(i, i + len);

                // Check if the substring is special (made up of only a single character)
                if (isSpecial(substring)) {
                    substringCount.put(substring, substringCount.getOrDefault(substring, 0) + 1);
                }
            }

            // Check if any special substring occurs at least thrice
            for (int count : substringCount.values()) {
                if (count >= 3) {
                    maxLength = len;
                    break;
                }
            }
        }

        return maxLength;
    }

    /**
     * Checks if a string is special (made up of only a single character).
     *
     * @param s the input string
     * @return true if the string is special, false otherwise
     */
    private boolean isSpecial(String s) {
        char firstChar = s.charAt(0);
        for (char c : s.toCharArray()) {
            if (c != firstChar) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestSpecialSubstringThatOccursThrice solution = new LongestSpecialSubstringThatOccursThrice();

        String s1 = "aaaa";
        System.out.println("Output (Test case 1): " + solution.longestSpecialSubstring(s1)); // Expected output: 2

        String s2 = "abcdef";
        System.out.println("Output (Test case 2): " + solution.longestSpecialSubstring(s2)); // Expected output: -1

        String s3 = "abcaba";
        System.out.println("Output (Test case 3): " + solution.longestSpecialSubstring(s3)); // Expected output: 1
    }
}