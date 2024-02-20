package leetcodeQuestions;

/**
 * This class provides a method to find the length of the last word in a string.
 */
public class LengthOfLastWord {

    /**
     * This method returns the length of the last word in a given string.
     * The last word is defined as the last sequence of non-space characters in the string.
     * If the string ends with spaces, they are ignored.
     *
     * @param s The string to find the last word's length from.
     * @return The length of the last word. If there are no words, returns 0.
     */
    public static int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Ignore trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count the length of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    /**
     * The main method that tests the lengthOfLastWord method with a sample string.
     *
     * @param args The command line arguments. Not used in this method.
     */
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}