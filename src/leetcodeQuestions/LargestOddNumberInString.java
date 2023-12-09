package leetcodeQuestions;

public class LargestOddNumberInString {

    public String largestOddNumber(String num) {
        // Start from the end of the string
        int i = num.length() - 1;
        // Loop until an odd number is found
        while (i >= 0) {
            // If the current number is odd, break the loop
            if (Integer.parseInt(String.valueOf(num.charAt(i))) % 2 != 0) {
                break;
            }
            // Decrease i
            i--;
        }
        // Return the substring from the start to the odd number
        return num.substring(0, i + 1);
    }
}