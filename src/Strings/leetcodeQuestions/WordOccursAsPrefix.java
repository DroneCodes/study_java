package Strings.leetcodeQuestions;

public class WordOccursAsPrefix {

    /**
     * Checks if searchWord is a prefix of any word in the sentence.
     *
     * @param sentence the input sentence
     * @param searchWord the word to search as a prefix
     * @return the 1-indexed position of the word where searchWord is a prefix, or -1 if no such word exists
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        WordOccursAsPrefix solution = new WordOccursAsPrefix();

        String sentence1 = "i love eating burger";
        String searchWord1 = "burg";
        System.out.println("Output (Test case 1): " + solution.isPrefixOfWord(sentence1, searchWord1)); // Expected output: 4

        String searchWord2 = "pro";
        String sentence2 = "this problem is an easy problem";
        System.out.println("Output (Test case 2): " + solution.isPrefixOfWord(sentence2, searchWord2)); // Expected output: 2

        String sentence3 = "i am tired";
        String searchWord3 = "you";
        System.out.println("Output (Test case 3): " + solution.isPrefixOfWord(sentence3, searchWord3)); // Expected output: -1
    }
}