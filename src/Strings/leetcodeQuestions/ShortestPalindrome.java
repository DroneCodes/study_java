package Strings.leetcodeQuestions;

public class ShortestPalindrome {

    /**
     * Finds the shortest palindrome by adding characters in front of the given string.
     *
     * The method works as follows:
     * 1. Create a new string `combined` by concatenating the original string `s`, a special character `#`, and the reversed string `rev`.
     * 2. Compute the KMP table (partial match table) for the `combined` string.
     * 3. The value at the last position of the KMP table gives the length of the longest prefix of `s` that matches a suffix of `rev`.
     * 4. Add the unmatched prefix of the reversed string to the front of the original string to form the shortest palindrome.
     *
     * @param s The input string.
     * @return The shortest palindrome that can be formed by adding characters in front of the input string.
     */
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        int[] kmpTable = computeKMPTable(combined);
        int longestPrefixLength = kmpTable[kmpTable.length - 1];
        return rev.substring(0, s.length() - longestPrefixLength) + s;
    }

    /**
     * Computes the KMP table (partial match table) for the given string.
     *
     * @param s The input string.
     * @return The KMP table for the input string.
     */
    private int[] computeKMPTable(String s) {
        int n = s.length();
        int[] kmpTable = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = kmpTable[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            kmpTable[i] = j;
        }
        return kmpTable;
    }

    public static void main(String[] args) {
        ShortestPalindrome obj = new ShortestPalindrome();
        String s = "aacecaaa";
        System.out.println(obj.shortestPalindrome(s)); // Output: "aaacecaaa"
    }
}