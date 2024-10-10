package Strings.leetcodeQuestions;

import java.util.Arrays;

/**
 * This class provides a method to check if one string is a permutation of another string.
 */
public class PermutationInString {

    /**
     * Checks if s1's permutation is a substring of s2.
     *
     * @param s1 the first string
     * @param s2 the second string
     * @return true if any permutation of s1 is a substring of s2, false otherwise
     */
    public boolean checkInclusion(String s1, String s2) {
        // If s1 is longer than s2, it's impossible for s1's permutation to be a substring of s2
        if (s1.length() > s2.length()) {
            return false;
        }

        // Arrays to count the frequency of each character in s1 and the current window of s2
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Count frequency of each character in s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Sliding window over s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            // If the character counts match, s1's permutation is a substring of s2
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
            // Slide the window: remove the first character of the current window and add the next character
            s2Count[s2.charAt(i) - 'a']--;
            s2Count[s2.charAt(i + s1.length()) - 'a']++;
        }

        // Check the last window
        return Arrays.equals(s1Count, s2Count);
    }

    /**
     * Main method to test the checkInclusion method with example test cases.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();

        // Test case 1
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(solution.checkInclusion(s1, s2)); // Output: true

        // Test case 2
        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println(solution.checkInclusion(s1, s2)); // Output: false
    }
}