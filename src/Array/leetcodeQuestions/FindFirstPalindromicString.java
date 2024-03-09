package Array.leetcodeQuestions;

public class FindFirstPalindromicString {

    public static String firstPalindrome(String[] str) {
        for (String string : str) {
            if (isPalindrome(string)) {
                return string;
            }
        }
        return "";
    }

    private static boolean isPalindrome(String string) {
        int start = 0;
        int end = string.length() - 1;
        while (start < end) {
            if (string.charAt(start) != string.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
