package leetcodeQuestions;

/**
 * This class provides a solution for the problem of determining whether a given non-negative integer can be expressed as the sum of squares of two integers.
 */
public class SumOfSquareNumbers {
    /**
     * This method checks if a given non-negative integer can be expressed as the sum of squares of two integers.
     *
     * @param c The non-negative integer to be checked.
     * @return true if the integer can be expressed as the sum of squares of two integers, false otherwise.
     */
    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = sqrt(c);
        long sum; // change sum to long
        while (a <= b) {
            sum = (long) a * a + (long) b * b; // cast a and b to long before squaring
            if (sum == c) {
                return true;
            } else if (sum < c) {
                a++;
            } else {
                b--;
            }
        }
        return false;
    }

    /**
     * This method calculates the square root of a given non-negative integer using binary search.
     *
     * @param num The non-negative integer whose square root is to be calculated.
     * @return The largest integer less than or equal to the square root of the given integer.
     */
    private int sqrt(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        int start = 1, end = num, ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid <= num / mid) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}