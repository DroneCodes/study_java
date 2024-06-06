package leetcodeQuestions;

import java.util.HashMap;

/**
 * This class is used to solve the problem of finding the length of the longest palindrome that can be built with the letters of a given string.
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome.
 */
public class LongestPalindrome {

    /**
     * This method calculates and returns the length of the longest palindrome that can be built with the letters of the input string.
     * It uses a HashMap to count the frequency of each character in the string.
     * Then, it iterates through the HashMap to add the count of each character to the length of the longest palindrome.
     * If the count is even, it adds the whole count. If the count is odd, it adds the count minus one.
     * After the iteration, if the length of the string is greater than the length of the longest palindrome, it means there are characters that appear an odd number of times, so it adds one to the length of the longest palindrome.
     *
     * @param s The input string. It consists only of lowercase and/or uppercase English letters and its length is between 1 and 2000.
     * @return The length of the longest palindrome that can be built with the letters of the input string.
     */
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        for (int count : counts.values()) {
            length += count / 2 * 2;
            if (length % 2 == 0 && count % 2 == 1) {
                length++;
            }
        }

        return length;
    }
}