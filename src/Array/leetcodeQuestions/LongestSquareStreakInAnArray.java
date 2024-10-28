package Array.leetcodeQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides methods to find the longest streak of perfect squares in an array.
 */
public class LongestSquareStreakInAnArray {

    /**
     * Checks if a given number is a perfect square.
     *
     * @param n the number to check
     * @return true if the number is a perfect square, false otherwise
     */
    private boolean perfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    /**
     * Finds the longest streak of perfect squares in the given array.
     *
     * @param nums the array of integers
     * @return the length of the longest streak of perfect squares, or -1 if no such streak exists
     */
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> streaks = new HashMap<>();
        int maxLength = -1;

        for (int num : nums) {
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num && streaks.containsKey(sqrt)) {
                streaks.put(num, streaks.get(sqrt) + 1);
            } else {
                streaks.put(num, 1);
            }

            if (streaks.get(num) >= 2) {
                maxLength = Math.max(maxLength, streaks.get(num));
            }
        }

        return maxLength;
    }

    /**
     * An alternative solution to find the longest streak of perfect squares in the given array.
     *
     * @param nums the array of integers
     * @return the length of the longest streak of perfect squares, or -1 if no such streak exists
     */
    public int secondEffectiveSolution(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> streaks = new HashMap<>();
        int maxLength = -1;

        for (int num : nums) {
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num && streaks.containsKey(sqrt)) {
                streaks.put(num, streaks.get(sqrt) + 1);
            } else {
                streaks.put(num, 1);
            }

            if (streaks.get(num) >= 2) {
                maxLength = Math.max(maxLength, streaks.get(num));
            }
        }

        return maxLength;
    }
}