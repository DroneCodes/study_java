package Array.leetcodeQuestions;

import java.util.Arrays;
import java.util.Comparator;

public class MostBeautifulItemForEachQuery {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Sort items by price, and by beauty in descending order if prices are the same
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // Create an array to store the results
        int[] result = new int[queries.length];

        // Create an array to store the original indices of the queries
        Integer[] queryIndices = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queryIndices[i] = i;
        }

        // Sort the queries while keeping track of their original indices
        Arrays.sort(queryIndices, Comparator.comparingInt(i -> queries[i]));

        int maxBeauty = 0;
        int itemIndex = 0;

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int query = queries[queryIndices[i]];

            // Update the maximum beauty for items with price <= query
            while (itemIndex < items.length && items[itemIndex][0] <= query) {
                maxBeauty = Math.max(maxBeauty, items[itemIndex][1]);
                itemIndex++;
            }

            // Store the result for the current query
            result[queryIndices[i]] = maxBeauty;
        }

        return result;
    }

    public static void main(String[] args) {
        MostBeautifulItemForEachQuery solution = new MostBeautifulItemForEachQuery();

        int[][] items1 = {{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
        int[] queries1 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(solution.maximumBeauty(items1, queries1))); // Output: [2, 4, 5, 5, 6, 6]

        int[][] items2 = {{1, 2}, {1, 2}, {1, 3}, {1, 4}};
        int[] queries2 = {1};
        System.out.println(Arrays.toString(solution.maximumBeauty(items2, queries2))); // Output: [4]

        int[][] items3 = {{10, 1000}};
        int[] queries3 = {5};
        System.out.println(Arrays.toString(solution.maximumBeauty(items3, queries3))); // Output: [0]
    }
}