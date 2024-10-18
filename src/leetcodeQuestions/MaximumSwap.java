package leetcodeQuestions;

public class MaximumSwap {
    /**
     * Returns the maximum valued number by swapping two digits at most once.
     *
     * @param num the input number
     * @return the maximum valued number
     */
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] last = new int[10];

        // Record the last occurrence of each digit
        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }

        // Traverse the digits to find the first digit that can be swapped
        for (int i = 0; i < digits.length; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    // Swap the digits
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    // Convert back to integer and return
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        MaximumSwap solution = new MaximumSwap();

        // Test case 1
        int num1 = 2736;
        System.out.println(solution.maximumSwap(num1)); // Output: 7236

        // Test case 2
        int num2 = 9973;
        System.out.println(solution.maximumSwap(num2)); // Output: 9973
    }
}