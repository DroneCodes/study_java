package leetcodeQuestions;

/**
 * This class contains methods to count the number of palindromic substrings in a given string.
 */
public class PalindromicSubstrings {

    /**
     * This method counts the number of palindromic substrings in a given string.
     * It iterates over the string, and for each character, it expands from the middle to find palindromic substrings.
     *
     * @param s The string in which to count palindromic substrings.
     * @return The count of palindromic substrings in the given string.
     */
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expandFromMiddle(s, i, i);
            count += expandFromMiddle(s, i, i + 1);
        }
        return count;
    }

    /**
     * This method expands from the middle of a given string to find palindromic substrings.
     * It checks if the characters at the left and right indices are the same, and if so, increments the count and expands further.
     *
     * @param s The string in which to find palindromic substrings.
     * @param left The left index from which to start expanding.
     * @param right The right index from which to start expanding.
     * @return The count of palindromic substrings found by expanding from the middle.
     */
    private static int expandFromMiddle(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    /**
     * The main method which serves as the entry point for the program.
     * It creates a string and prints the count of palindromic substrings in it.
     *
     * @param args The command-line arguments. Not used in this program.
     */
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }
}