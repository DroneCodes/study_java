package Strings.leetcodeQuestions;

public class StringCompressionIII {
    /**
     * Compresses the given word using the specified algorithm.
     *
     * @param word The input word to compress.
     * @return The compressed string.
     */
    public static String compress(String word) {
        StringBuilder comp = new StringBuilder();
        int i = 0;
        int n = word.length();

        while (i < n) {
            char c = word.charAt(i);
            int count = 0;

            // Count the number of consecutive characters c, up to 9
            while (i < n && word.charAt(i) == c && count < 9) {
                count++;
                i++;
            }

            // Append the count and character to the result
            comp.append(count).append(c);
        }

        return comp.toString();
    }

    public static void main(String[] args) {
        String word1 = "abcde";
        String word2 = "aaaaaaaaaaaaaabb";

        System.out.println(compress(word1)); // Output: "1a1b1c1d1e"
        System.out.println(compress(word2)); // Output: "9a5a2b"
    }
}
