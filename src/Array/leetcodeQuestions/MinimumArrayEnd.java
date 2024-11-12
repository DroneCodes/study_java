package Array.leetcodeQuestions;

public class MinimumArrayEnd {
    /**
     * Constructs an array of positive integers of size n where for every 0 <= i < n - 1,
     * nums[i + 1] is greater than nums[i], and the result of the bitwise AND operation
     * between all elements of nums is x. Returns the minimum possible value of nums[n - 1].
     *
     * @param n The size of the array.
     * @param x The target bitwise AND result.
     * @return The minimum possible value of nums[n - 1].
     */
    public long getMinimumPossibleValue(int n, int x) {
        // Initialize result with the value of x
        long result = x;
        // Calculate the remaining number of elements to be added
        long remaining = n - 1;
        // Initialize the position to 1 (binary 0001)
        long position = 1;

        // Loop until there are no remaining elements to be added
        while (remaining != 0) {
            // Check if the current bit position in x is 0
            if ((x & position) == 0) {
                // If the current bit in x is 0, set the corresponding bit in result
                result |= (remaining & 1) * position;
                // Right shift remaining by 1 to process the next bit
                remaining >>= 1;
            }
            // Left shift position by 1 to move to the next bit
            position <<= 1;
        }

        // Return the final result which is the minimum possible value of nums[n - 1]
        return result;
    }

    public static void main(String[] args) {
        MinimumArrayEnd solution = new MinimumArrayEnd();
        // Test the function with n = 3 and x = 4, expected output is 6
        System.out.println(solution.getMinimumPossibleValue(3, 4)); // Output: 6
        // Test the function with n = 2 and x = 7, expected output is 15
        System.out.println(solution.getMinimumPossibleValue(2, 7)); // Output: 15
    }
}