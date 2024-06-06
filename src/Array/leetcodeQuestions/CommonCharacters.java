package Array.leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to solve the problem of finding all characters that show up in all strings within the words (including duplicates).
 * The characters are returned in any order.
 */
public class CommonCharacters {

    /**
     * This method calculates and returns a list of all characters that show up in all strings within the words (including duplicates).
     * It uses an array of size 26 (for each lowercase English letter) to count the frequency of each character in the first string.
     * Then, for each of the remaining strings, it creates a new count array and updates the original count array to be the minimum of the original count and the new count.
     * This is because a character can only appear in the final result as many times as it appears in every string.
     * Finally, it iterates through the count array and adds each character to the result as many times as its count.
     *
     * @param words The input string array. It consists only of lowercase English letters and its length is between 1 and 100.
     * @return A list of all characters that show up in all strings within the words (including duplicates).
     */
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        for (char c : words[0].toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 1; i < words.length; i++) {
            int[] count2 = new int[26];
            for (char c : words[i].toCharArray()) {
                count2[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                count[j] = Math.min(count[j], count2[j]);
            }
        }

        List<String> result = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a']-- > 0) {
                result.add(String.valueOf(c));
            }
        }

        return result;
    }
}