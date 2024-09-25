package Array.leetcodeQuestions;

import java.util.HashMap;
import java.util.Map;

public class SumOfPrefixScoresOfString {
    // Trie Node class
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }

    // Root of the Trie
    private TrieNode root = new TrieNode();

    /**
     * Inserts a word into the Trie and updates the count of nodes.
     *
     * @param word the word to be inserted
     */
    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
            node.count++;
        }
    }

    /**
     * Calculates the score of a word by summing the counts of all its prefixes.
     *
     * @param word the word to calculate the score for
     * @return the score of the word
     */
    private int calculateScore(String word) {
        TrieNode node = root;
        int score = 0;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            score += node.count;
        }
        return score;
    }

    /**
     * Returns an array where each element is the sum of scores of every non-empty prefix of words[i].
     *
     * @param words the array of words
     * @return the array of scores
     */
    public int[] sumOfPrefixScores(String[] words) {
        // Insert all words into the Trie
        for (String word : words) {
            insert(word);
        }

        // Calculate the score for each word
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = calculateScore(words[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        SumOfPrefixScoresOfString solver = new SumOfPrefixScoresOfString();

        // Test case 1
        String[] words1 = {"abc", "ab", "bc", "b"};
        int[] result1 = solver.sumOfPrefixScores(words1);
        for (int score : result1) {
            System.out.print(score + " ");
        }
        // Output: 5 4 3 2

        // Test case 2
        String[] words2 = {"abcd"};
        int[] result2 = solver.sumOfPrefixScores(words2);
        for (int score : result2) {
            System.out.print(score + " ");
        }
        // Output: 4
    }
}
