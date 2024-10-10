package Strings.leetcodeQuestions;

public class SentenceSimilarityIII {
    /**
     * Determines if two sentences are similar. Two sentences are similar if one sentence can be obtained from the other by
     * inserting or deleting some words at the beginning or the end of the other sentence.
     *
     * @param sentence1 the first sentence
     * @param sentence2 the second sentence
     * @return true if the sentences are similar, false otherwise
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int i = 0, j = 0;
        int n1 = words1.length, n2 = words2.length;

        // Compare words from the beginning
        while (i < n1 && i < n2 && words1[i].equals(words2[i])) {
            i++;
        }

        // Compare words from the end
        while (j < n1 - i && j < n2 - i && words1[n1 - 1 - j].equals(words2[n2 - 1 - j])) {
            j++;
        }

        // Check if all words from one of the sentences are matched
        return i + j == Math.min(n1, n2);
    }

    /**
     * Main method to test the areSentencesSimilar method with example test cases.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SentenceSimilarityIII solution = new SentenceSimilarityIII();

        // Test case 1
        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";
        System.out.println(solution.areSentencesSimilar(sentence1, sentence2)); // Output: true

        // Test case 2
        sentence1 = "of";
        sentence2 = "A lot of words";
        System.out.println(solution.areSentencesSimilar(sentence1, sentence2)); // Output: false

        // Test case 3
        sentence1 = "Eating right now";
        sentence2 = "Eating";
        System.out.println(solution.areSentencesSimilar(sentence1, sentence2)); // Output: true
    }
}