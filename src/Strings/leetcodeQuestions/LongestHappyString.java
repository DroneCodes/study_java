package Strings.leetcodeQuestions;

import java.util.PriorityQueue;

public class LongestHappyString {
    /**
     * Returns the longest possible happy string given the counts of 'a', 'b', and 'c'.
     * The string should not contain "aaa", "bbb", or "ccc" as substrings.
     *
     * @param a the count of 'a'
     * @param b the count of 'b'
     * @param c the count of 'c'
     * @return the longest possible happy string
     */
    public String longestDiverseString(int a, int b, int c) {
        // We use a max-heap (priority queue) to always try to add the character with the highest remaining count.
        PriorityQueue<CharCount> maxHeap = new PriorityQueue<>((x, y) -> y.count - x.count);

        // Add 'a', 'b', and 'c' to the heap if their counts are greater than 0.
        if (a > 0) maxHeap.add(new CharCount('a', a));
        if (b > 0) maxHeap.add(new CharCount('b', b));
        if (c > 0) maxHeap.add(new CharCount('c', c));

        // StringBuilder to build the result string.
        StringBuilder result = new StringBuilder();

        // Continue until the heap is empty.
        while (!maxHeap.isEmpty()) {
            // Poll the character with the highest remaining count.
            CharCount first = maxHeap.poll();

            // Check if adding this character would violate the "no three consecutive characters" rule.
            if (result.length() >= 2 && result.charAt(result.length() - 1) == first.ch && result.charAt(result.length() - 2) == first.ch) {
                // If it would violate the rule and the heap is empty, break the loop.
                if (maxHeap.isEmpty()) break;

                // Otherwise, poll the next character with the highest count.
                CharCount second = maxHeap.poll();
                // Append this character to the result.
                result.append(second.ch);
                // Decrease its count and add it back to the heap if it still has remaining counts.
                if (--second.count > 0) maxHeap.add(second);
                // Add the first character back to the heap.
                maxHeap.add(first);
            } else {
                // If it does not violate the rule, append the character to the result.
                result.append(first.ch);
                // Decrease its count and add it back to the heap if it still has remaining counts.
                if (--first.count > 0) maxHeap.add(first);
            }
        }

        // Return the constructed happy string.
        return result.toString();
    }

    // Helper class to store the character and its remaining count.
    private static class CharCount {
        char ch;
        int count;

        CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        LongestHappyString solution = new LongestHappyString();

        // Test case 1: a = 1, b = 1, c = 7
        // Expected output: "ccaccbcc" or similar
        System.out.println(solution.longestDiverseString(1, 1, 7));

        // Test case 2: a = 7, b = 1, c = 0
        // Expected output: "aabaa"
        System.out.println(solution.longestDiverseString(7, 1, 0));
    }
}