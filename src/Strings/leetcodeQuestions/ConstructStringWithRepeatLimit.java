package Strings.leetcodeQuestions;

import java.util.PriorityQueue;

/**
 * This class provides a method to construct the lexicographically largest string
 * using the characters of a given string such that no letter appears more than
 * a specified number of times consecutively.
 */
public class ConstructStringWithRepeatLimit {

    /**
     * Constructs the lexicographically largest string using the characters of the given string
     * such that no letter appears more than repeatLimit times consecutively.
     *
     * @param s The input string consisting of lowercase English letters.
     * @param repeatLimit The maximum number of times a letter can appear consecutively.
     * @return The lexicographically largest string satisfying the repeat limit constraint.
     */
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        // Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Max-heap to get the largest character available
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer((char) (i + 'a'));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            int count = Math.min(freq[current - 'a'], repeatLimit);

            // Append the current character up to the repeat limit
            for (int i = 0; i < count; i++) {
                result.append(current);
            }

            freq[current - 'a'] -= count;

            // If there are more occurrences of the current character
            if (freq[current - 'a'] > 0) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                char next = maxHeap.poll();
                result.append(next);
                freq[next - 'a']--;
                if (freq[next - 'a'] > 0) {
                    maxHeap.offer(next);
                }
                maxHeap.offer(current);
            }
        }

        return result.toString();
    }

    /**
     * Main method to test the repeatLimitedString method.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        ConstructStringWithRepeatLimit solution = new ConstructStringWithRepeatLimit();
        System.out.println(solution.repeatLimitedString("cczazcc", 3)); // Output: "zzcccac"
        System.out.println(solution.repeatLimitedString("aababab", 2)); // Output: "bbabaa"
    }
}