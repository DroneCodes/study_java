package Strings.leetcodeQuestions;

public class CircularSentence {

    /**
     * Checks if the given sentence is circular.
     *
     * @param sentence The input sentence.
     * @return true if the sentence is circular, false otherwise.
     */

    public static boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;

        for (int i = 0; i < n; i++) {
            String currentWord = words[i];
            String nextWord = words[(i + 1) % n];
            if (currentWord.charAt(currentWord.length() - 1) != nextWord.charAt(0)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String sentence1 = "leetcode exercises sound delightful";
        String sentence2 = "eetcode";
        String sentence3 = "Leetcode is cool";

        System.out.println(isCircularSentence(sentence1)); // true
        System.out.println(isCircularSentence(sentence2)); // true
        System.out.println(isCircularSentence(sentence3)); // false
    }
}
