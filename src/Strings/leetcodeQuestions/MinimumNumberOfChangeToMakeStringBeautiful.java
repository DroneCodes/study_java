package Strings.leetcodeQuestions;

public class MinimumNumberOfChangeToMakeStringBeautiful {

    /**
     * Returns the minimum number of changes required to make the string s beautiful.
     *
     * @param s The input binary string.
     * @return The minimum number of changes required.
     */
    public static int minChangesToMakeBeautiful(String s) {
        int changes = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                changes++;
            }
        }
        return changes;
    }

    public static void main(String[] args) {
        String s1 = "1001";
        String s2 = "10";
        String s3 = "0000";

        System.out.println(minChangesToMakeBeautiful(s1)); // Output: 2
        System.out.println(minChangesToMakeBeautiful(s2)); // Output: 1
        System.out.println(minChangesToMakeBeautiful(s3)); // Output: 0
    }
}