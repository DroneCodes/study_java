package Array.leetcodeQuestions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DivideIntervalsIntoMinimumNumberOfGroups {
    /**
     * Returns the minimum number of groups needed to divide the intervals such that no two intervals in the same group intersect.
     *
     * @param intervals the 2D array of intervals
     * @return the minimum number of groups needed
     */
    public int minGroups(int[][] intervals) {
        // Sort intervals by their start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Priority queue to keep track of the end times of the groups
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Iterate through each interval
        for (int[] interval : intervals) {
            // If the current interval can be added to an existing group
            if (!pq.isEmpty() && pq.peek() < interval[0]) {
                pq.poll(); // Remove the group with the smallest end time
            }
            pq.add(interval[1]); // Add the current interval's end time to the priority queue
        }

        // The size of the priority queue is the minimum number of groups needed
        return pq.size();
    }

    public static void main(String[] args) {
        DivideIntervalsIntoMinimumNumberOfGroups solution = new DivideIntervalsIntoMinimumNumberOfGroups();

        // Test case 1
        int[][] intervals1 = {{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};
        System.out.println(solution.minGroups(intervals1)); // Output: 3

        // Test case 2
        int[][] intervals2 = {{1, 3}, {5, 6}, {8, 10}, {11, 13}};
        System.out.println(solution.minGroups(intervals2)); // Output: 1
    }
}