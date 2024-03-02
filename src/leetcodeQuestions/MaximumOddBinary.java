package leetcodeQuestions;

public class MaximumOddBinary {

    /**
     * This method rearranges the bits in a binary string to form the maximum odd binary number.
     *
     * @param s The binary string to be rearranged. It should contain at least one '1'.
     * @return A string representing the maximum odd binary number that can be created from the given combination.
     *
     * The method works as follows:
     * 1. It counts the number of '1's and '0's in the string.
     * 2. Since the last digit of the maximum odd binary number must be '1', it subtracts one from the count of '1's.
     * 3. It forms the maximum odd binary number by placing all the '0's after the first '1', and then placing the remaining '1's at the beginning of the number.
     * 4. If there are no '1's left after subtracting one for the last digit, it returns "1" followed by all the '0's.
     */
    public String maximumOddBinary(String s) {
        int ones = 0, zeros = 0;
        // Count the number of '1's and '0's
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            } else {
                zeros++;
            }
        }

        // If there are no '1's, return "0"
        if (ones == 0) {
            return "0";
        }

        // One '1' should be at the end
        ones--;

        StringBuilder sb = new StringBuilder();
        // Append '1's at the beginning
        while (ones-- > 0) {
            sb.append('1');
        }
        // Append '0's after the first '1'
        while (zeros-- > 0) {
            sb.append('0');
        }
        // Append the last '1'
        sb.append('1');

        return sb.toString();
    }
}