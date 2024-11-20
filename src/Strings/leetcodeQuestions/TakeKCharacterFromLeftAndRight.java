package Strings.leetcodeQuestions;

/**
 * This class provides a method to find the minimum number of minutes needed to take at least k of each character ('a', 'b', and 'c')
 * from both ends of the string.
 */
public class TakeKCharacterFromLeftAndRight {

    /**
     * Finds the minimum number of minutes needed to take at least k of each character ('a', 'b', and 'c') from both ends of the string.
     *
     * @param s the input string consisting of characters 'a', 'b', and 'c'
     * @param k the number of each character to take
     * @return the minimum number of minutes needed, or -1 if it is not possible
     */
    public int minMinutesToTakeKCharacters(String s, int k) {
        // Total counts
        int[] count = new int[3];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        boolean b = Math.min(Math.min(count[0], count[1]), count[2]) < k;
        if (b) {
            return -1;
        }

        // Sliding Window
        int res = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'a']--;

            while (b) {
                count[s.charAt(l) - 'a']++;
                l++;
            }
            res = Math.min(res, s.length() - (r - l + 1));
        }
        return res;
    }

    /**
     * Main method to test the minMinutesToTakeKCharacters method with different examples.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        TakeKCharacterFromLeftAndRight solution = new TakeKCharacterFromLeftAndRight();

        String s1 = "aabaaaacaabc";
        int k1 = 2;
        System.out.println(solution.minMinutesToTakeKCharacters(s1, k1)); // Output: 8

        String s2 = "a";
        int k2 = 1;
        System.out.println(solution.minMinutesToTakeKCharacters(s2, k2)); // Output: -1
    }
}