package Array.leetcodeQuestions;

public class LargestCombinationWithBitwiseAndGreaterThanZero {

    /**
     * Returns the size of the largest combination of candidates with a bitwise AND greater than 0.
     *
     * @param candidates The input array of positive integers.
     * @return The size of the largest combination.
     */
    public static int largestCombination(int[] candidates) {
        int[] bitCount = new int[24]; // Since 1 <= candidates[i] <= 10^7, we need 24 bits to represent the numbers.

        // Count the number of set bits at each position
        for (int num : candidates) {
            for (int i = 0; i < 24; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }

        // Find the maximum count of set bits at any position
        int maxCombinationSize = 0;
        for (int count : bitCount) {
            maxCombinationSize = Math.max(maxCombinationSize, count);
        }

        return maxCombinationSize;
    }

    public static void main(String[] args) {
        int[] candidates1 = {16, 17, 71, 62, 12, 24, 14};
        int[] candidates2 = {8, 8};

        System.out.println(largestCombination(candidates1)); // Output: 4
        System.out.println(largestCombination(candidates2)); // Output: 2
    }
}