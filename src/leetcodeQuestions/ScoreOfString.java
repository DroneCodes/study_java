package leetcodeQuestions;

/**
 * This class is used to solve the problem of calculating the score of a string.
 * The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.
 */
public class ScoreOfString {

    /**
     * This method calculates and returns the score of the input string.
     * It iterates over the string and calculates the absolute difference between the ASCII values of each pair of adjacent characters.
     * The score is the sum of these absolute differences.
     *
     * @param s The input string. It consists only of lowercase English letters and its length is between 2 and 100.
     * @return The score of the input string.
     */
    public int stringScore(String s) {
        int score = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }
}