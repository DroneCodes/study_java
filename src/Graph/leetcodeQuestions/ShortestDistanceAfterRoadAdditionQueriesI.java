package Graph.leetcodeQuestions;

import java.util.*;

public class ShortestDistanceAfterRoadAdditionQueriesI {

    /**
     * Finds the shortest path from city 0 to city n-1 after each query.
     *
     * @param n the number of cities
     * @param queries the queries representing the addition of new roads
     * @return an array where each element is the length of the shortest path after each query
     */
    public int[] shortestPathAfterQueries(int n, int[][] queries) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Initialize the graph with the initial roads
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(new int[]{i + 1, 1});
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            graph.get(u).add(new int[]{v, 1});

            result[i] = dijkstra(graph, n);
        }

        return result;
    }

    /**
     * Uses Dijkstra's algorithm to find the shortest path from city 0 to city n-1.
     *
     * @param graph the graph representing the cities and roads
     * @param n the number of cities
     * @return the length of the shortest path from city 0 to city n-1
     */
    private int dijkstra(List<List<int[]>> graph, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int d = current[1];

            if (d > dist[u]) {
                continue;
            }

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        return dist[n - 1];
    }

    /**
     * Main method to test the shortestPathAfterQueries method with different examples.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ShortestDistanceAfterRoadAdditionQueriesI solution = new ShortestDistanceAfterRoadAdditionQueriesI();

        int n1 = 5;
        int[][] queries1 = {{2, 4}, {0, 2}, {0, 4}};
        System.out.println(Arrays.toString(solution.shortestPathAfterQueries(n1, queries1))); // Output: [3, 2, 1]

        int n2 = 4;
        int[][] queries2 = {{0, 3}, {0, 2}};
        System.out.println(Arrays.toString(solution.shortestPathAfterQueries(n2, queries2))); // Output: [1, 1]
    }
}