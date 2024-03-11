package leetcodeQuestions;

/**
 * The CustomSortString class provides a method to permute the characters of a string so that they match a custom order.
 */
public class CustomSortString {

    /**
     * This method permutes the characters of a string so that they match a custom order.
     * The order is specified by another string. All the characters of the order string are unique.
     *
     * @param order A string of unique characters that specifies the custom order.
     * @param s A string to be permuted.
     * @return A permutation of the string s that matches the custom order.
     */
    public String customSortString(String order, String s) {
        // An array to store the frequencies of the characters in the string s.
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // A StringBuilder to build the result string.
        StringBuilder sb = new StringBuilder();

        // Append the characters in the order string to the result string in the order they appear.
        for (char c : order.toCharArray()) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }

        // Append the remaining characters in the string s to the result string.
        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}