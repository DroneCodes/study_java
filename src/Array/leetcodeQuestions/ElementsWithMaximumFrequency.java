package Array.leetcodeQuestions;

/**
 * The ElementsWithMaximumFrequency class provides a method to calculate the total frequencies of elements in an array
 * that have the maximum frequency.
 */
public class ElementsWithMaximumFrequency {

    /**
     * This method calculates the total frequencies of elements in an array that have the maximum frequency.
     *
     * @param nums An array of positive integers. Each integer is between 1 and 100 inclusive.
     * @return The total frequencies of elements in the array that have the maximum frequency.
     */
    public int totalMaxFrequency(int[] nums) {
        // An array to store the frequencies of the elements in the input array.
        int[] freq = new int[101];
        // The maximum frequency found so far.
        int maxFreq = 0;
        // The total frequencies of elements that have the maximum frequency.
        int total = 0;

        // Count the frequencies of the elements in the input array.
        for (int num : nums) {
            freq[num]++;
            maxFreq = Math.max(maxFreq, freq[num]);
        }

        // Count the total frequencies of elements that have the maximum frequency.
        for (int f : freq) {
            if (f == maxFreq) {
                total += f;
            }
        }

        return total;
    }
}