package Strings.leetcodeQuestions;

public class MakeStringASubsequenceUsingCyclicIncrements {

    /**
     * Checks if str2 can be made a subsequence of str1 by incrementing characters in str1 at most once.
     *
     * @param str1 the input string to be modified
     * @param str2 the target subsequence string
     * @return true if str2 can be made a subsequence of str1, false otherwise
     */
    public boolean canMakeSubsequence(String str1, String str2) {
        int str2Index = 0;
        int str2Length = str2.length();

        for (char currChar : str1.toCharArray()) {
            if (str2Index < str2Length && (str2.charAt(str2Index) - currChar + 26) % 26 <= 1) {
                str2Index++;
            }
        }

        return str2Index == str2Length;
    }

    public static void main(String[] args) {
        MakeStringASubsequenceUsingCyclicIncrements solution = new MakeStringASubsequenceUsingCyclicIncrements();

        String str1 = "abc";
        String str2 = "ad";
        System.out.println("Output (Test case 1): " + solution.canMakeSubsequence(str1, str2)); // Expected output: true

        String str1_2 = "zc";
        String str2_2 = "ad";
        System.out.println("Output (Test case 2): " + solution.canMakeSubsequence(str1_2, str2_2)); // Expected output: true

        String str1_3 = "ab";
        String str2_3 = "d";
        System.out.println("Output (Test case 3): " + solution.canMakeSubsequence(str1_3, str2_3)); // Expected output: false
    }
}