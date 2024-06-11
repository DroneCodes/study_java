package Array.leetcodeQuestions;

import java.util.Arrays;

/**
 * This class contains a method to check the number of students standing out of their expected positions.
 */
public class HeightChecker {

    /**
     * This method checks the number of students standing out of their expected positions.
     * The students are expected to stand in a non-decreasing order by their heights.
     *
     * @param heights The array of heights of the students.
     * @return The number of students standing out of their expected positions.
     */
    public int heightChecker(int[] heights) {
        // Create a copy of the original heights array and sort it
        int[] expected = heights.clone();
        Arrays.sort(expected);

        int count = 0;
        // Iterate over the heights array and compare each element with the corresponding element in the sorted array
        for (int i = 0; i < heights.length; i++) {
            // If the elements are not equal, increment the counter
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        // Return the counter after the loop ends
        return count;
    }
}