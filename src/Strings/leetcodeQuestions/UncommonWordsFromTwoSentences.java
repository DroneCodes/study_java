package Strings.leetcodeQuestions;

import java.util.*;

public class UncommonWordsFromTwoSentences {
    /**
     * Finds all uncommon words from two sentences.
     * <p>
     * This method takes two sentences as input and returns an array of words that are uncommon.
     * A word is considered uncommon if it appears exactly once in one of the sentences and does not appear in the other sentence.
     * <p>
     * The method works as follows:
     * 1. It combines both sentences into a single string and splits it into individual words.
     * 2. It uses a HashMap to count the occurrences of each word.
     * 3. It iterates through the map to collect words that appear exactly once.
     * 4. It returns these uncommon words as an array of strings.
     *
     * @param s1 The first sentence.
     * @param s2 The second sentence.
     * @return An array of all uncommon words.
     */
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> wordCount = new HashMap<>();

        // Split both sentences into words and count their occurrences
        for (String word : (s1 + " " + s2).split(" ")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Collect words that appear exactly once
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        UncommonWordsFromTwoSentences solver = new UncommonWordsFromTwoSentences();

        // Test case 1
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println(Arrays.toString(solver.uncommonFromSentences(s1, s2))); // Output: ["sweet", "sour"]

        // Test case 2
        s1 = "apple apple";
        s2 = "banana";
        System.out.println(Arrays.toString(solver.uncommonFromSentences(s1, s2))); // Output: ["banana"]
    }
}