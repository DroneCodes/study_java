package DynamicProgramming;

import java.util.Arrays;

/**
 * The TwoBestNonOverlappingEvents class provides a method to determine the maximum sum of values
 * by attending at most two non-overlapping events.
 */
public class TwoBestNonOverlappingEvents {

    /**
     * Finds the maximum sum of values by attending at most two non-overlapping events.
     *
     * @param events a 2D array where each element represents an event with start time, end time, and value
     * @return the maximum sum of values by attending at most two non-overlapping events
     */
    public int maxTwoEvents(int[][] events) {
        // Sort events by their start times
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int n = events.length;

        // Array to store the maximum value from the current event to the last event
        int[] maxValue = new int[n];
        maxValue[n - 1] = events[n - 1][2];
        for (int i = n - 2; i >= 0; --i) {
            maxValue[i] = Math.max(maxValue[i + 1], events[i][2]);
        }

        int result = 0;

        for (int i = 0; i < n; ++i) {
            int currValue = events[i][2];
            result = Math.max(result, currValue);

            // Binary search to find the next non-overlapping event
            int lo = i + 1, hi = n - 1, nextEvent = -1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (events[mid][0] > events[i][1]) {
                    nextEvent = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            // Update the result with the sum of the current event value and the maximum value of the next non-overlapping event
            if (nextEvent != -1) {
                result = Math.max(result, currValue + maxValue[nextEvent]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TwoBestNonOverlappingEvents solution = new TwoBestNonOverlappingEvents();

        int[][] events1 = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        System.out.println("Output (Test case 1): " + solution.maxTwoEvents(events1)); // Expected output: 4

        int[][] events2 = {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}};
        System.out.println("Output (Test case 2): " + solution.maxTwoEvents(events2)); // Expected output: 5

        int[][] events3 = {{1, 5, 3}, {1, 5, 1}, {6, 6, 5}};
        System.out.println("Output (Test case 3): " + solution.maxTwoEvents(events3)); // Expected output: 8
    }
}