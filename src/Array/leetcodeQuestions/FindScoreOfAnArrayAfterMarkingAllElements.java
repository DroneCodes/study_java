package Array.leetcodeQuestions;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * This class provides a method to find the score of an array after marking all elements.
 * The score is calculated by repeatedly finding the smallest element, marking it and its adjacent elements,
 * and summing the values of the marked elements.
 */
public class FindScoreOfAnArrayAfterMarkingAllElements {

    /**
     * Finds the score of the array after marking all elements.
     *
     * @param nums the input array of integers
     * @return the score after marking all elements
     */
    public long findScore(int[] nums) {
        // Use a priority queue to efficiently find the minimum element
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        // Add each element with its index to the priority queue
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        // Track marked indices
        boolean[] marked = new boolean[nums.length];
        long score = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int value = current[0];
            int index = current[1];

            // Skip if already marked
            if (marked[index]) continue;

            // Mark current and adjacent indices
            marked[index] = true;
            score += value;

            // Mark adjacent indices
            if (index > 0) marked[index - 1] = true;
            if (index < nums.length - 1) marked[index + 1] = true;
        }

        return score;
    }
}