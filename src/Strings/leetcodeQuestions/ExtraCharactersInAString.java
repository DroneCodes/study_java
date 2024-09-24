package Strings.leetcodeQuestions;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides a method to find the minimum number of extra characters left over
 * when breaking a string into one or more non-overlapping substrings that are present in a given dictionary.
 */
public class ExtraCharactersInAString {

    /**
     * Finds the minimum number of extra characters left over if the string `s` is broken up optimally
     * using the words in the given dictionary.
     *
     * @param s the input string to be broken up
     * @param dictionary an array of words that can be used to break up the string
     * @return the minimum number of extra characters left over
     */
    public int minExtraChar(String s, String[] dictionary) {
        // Convert the dictionary array to a set for faster lookup
        Set<String> dict = new HashSet<>();
        for (String word : dictionary) {
            dict.add(word);
        }

        int n = s.length();
        // Initialize the DP array with the worst case: all characters are extra
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        // No extra characters for an empty string
        dp[0] = 0;

        // Iterate through the string to fill the DP array
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // If the substring s[j:i] is in the dictionary, update dp[i]
                if (dict.contains(s.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
            // Consider the current character as extra
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }

        // Return the minimum number of extra characters for the entire string
        return dp[n];
    }

    /**
     * Main method to test the minExtraChar method with example inputs.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ExtraCharactersInAString obj = new ExtraCharactersInAString();
        String s1 = "leetscode";
        String[] dictionary1 = {"leet", "code", "leetcode"};
        System.out.println(obj.minExtraChar(s1, dictionary1)); // Output: 1

        String s2 = "sayhelloworld";
        String[] dictionary2 = {"hello", "world"};
        System.out.println(obj.minExtraChar(s2, dictionary2)); // Output: 3
    }
}