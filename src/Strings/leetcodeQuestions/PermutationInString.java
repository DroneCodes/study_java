package Strings.leetcodeQuestions;
import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Count frequency of each character in s1
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Sliding window over s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
            // Slide the window: remove the first character of the current window and add the next character
            s2Count[s2.charAt(i) - 'a']--;
            s2Count[s2.charAt(i + s1.length()) - 'a']++;
        }

        // Check the last window
        return Arrays.equals(s1Count, s2Count);
    }

    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();

        // Test case 1
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(solution.checkInclusion(s1, s2)); // Output: true

        // Test case 2
        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println(solution.checkInclusion(s1, s2)); // Output: false
    }
}
