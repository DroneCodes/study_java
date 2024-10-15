package Strings.leetcodeQuestions;

public class SeparateWhiteAndBlackBalls {
    /**
     * Returns the minimum number of swaps needed to group all black balls to the right and all white balls to the left.
     *
     * @param s the binary string representing the balls
     * @return the minimum number of swaps needed
     */
    public int minSwaps(String s) {
        int n = s.length();
        int zeroCount = 0;
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                zeroCount++;
            } else if (s.charAt(i) == '0') {
                swaps += zeroCount;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        SeparateWhiteAndBlackBalls solution = new SeparateWhiteAndBlackBalls();

        // Test case 1
        String s1 = "101";
        System.out.println(solution.minSwaps(s1)); // Output: 1

        // Test case 2
        String s2 = "100";
        System.out.println(solution.minSwaps(s2)); // Output: 2

        // Test case 3
        String s3 = "0111";
        System.out.println(solution.minSwaps(s3)); // Output: 0
    }
}