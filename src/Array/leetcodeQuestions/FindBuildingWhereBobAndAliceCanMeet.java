package Array.leetcodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindBuildingWhereBobAndAliceCanMeet {

    /**
     * This method processes the queries to find the leftmost building where Bob and Alice can meet.
     *
     * @param heights An array of integers representing the heights of the buildings.
     * @param queries A 2D array of integers where each query is represented by an array of two integers [a, b].
     * @return An array of integers where each element is the result of the corresponding query.
     */
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        // List to store queries for each building index
        List<List<List<Integer>>> storeQueries = new ArrayList<>(heights.length);
        for (int i = 0; i < heights.length; i++) {
            storeQueries.add(new ArrayList<>());
        }

        // Priority queue to store the maximum index pairs
        PriorityQueue<List<Integer>> maxIndex = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);

        // Store the mappings for all queries in storeQueries
        for (int currQuery = 0; currQuery < queries.length; currQuery++) {
            int a = queries[currQuery][0], b = queries[currQuery][1];
            if (a < b && heights[a] < heights[b]) {
                result[currQuery] = b;
            } else if (a > b && heights[a] > heights[b]) {
                result[currQuery] = a;
            } else if (a == b) {
                result[currQuery] = a;
            } else {
                storeQueries.get(Math.max(a, b)).add(Arrays.asList(Math.max(heights[a], heights[b]), currQuery));
            }
        }

        // Process the priority queue and update the result array
        for (int index = 0; index < heights.length; index++) {
            while (!maxIndex.isEmpty() && maxIndex.peek().get(0) < heights[index]) {
                result[maxIndex.peek().get(1)] = index;
                maxIndex.poll();
            }
            // Push the elements with their maximum index as the current index in the priority queue
            for (List<Integer> element : storeQueries.get(index)) {
                maxIndex.offer(element);
            }
        }
        return result;
    }
}