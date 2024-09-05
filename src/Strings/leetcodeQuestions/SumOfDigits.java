package Strings.leetcodeQuestions;

import java.util.HashMap;

/**
 * This class provides a method to calculate the sum of digits of a string
 * after converting each character to its corresponding position in the alphabet
 * and performing a series of transformations.
 */
public class SumOfDigits {

    /**
     * Converts each character in the string to its corresponding position in the alphabet,
     * sums the digits of the resulting number, and repeats the process k times.
     *
     * @param s the input string consisting of lowercase English letters
     * @param k the number of transformations to perform
     * @return the resulting sum after k transformations
     */
    public int getLucky(String s, int k) {
        // Create a HashMap to store the position of each alphabet character
        HashMap<String, Integer> alphabets = new HashMap<>();
        String str = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < str.length(); i++) {
            alphabets.put(String.valueOf(str.charAt(i)), i + 1);
        }

        // Convert each character in the input string to its corresponding position
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(alphabets.get(String.valueOf(s.charAt(i))));
        }
        String str1 = sb.toString();

        // Calculate the sum of digits of the resulting number
        int sum = 0;
        for (int i = 0; i < str1.length(); i++) {
            sum += Integer.parseInt(String.valueOf(str1.charAt(i)));
        }

        // Perform the transformation k times
        for (int i = 1; i < k; i++) {
            sum = getSum(sum);
        }
        return sum;
    }

    /**
     * Helper method to calculate the sum of digits of a given number.
     *
     * @param sum the input number
     * @return the sum of digits of the input number
     */
    private int getSum(int sum) {
        int res = 0;
        while (sum > 0) {
            res += sum % 10;
            sum /= 10;
        }
        return res;
    }
}