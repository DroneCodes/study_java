package Trees.leetcodequestions;

import java.util.*;

public class MaxComponentsInValidSplit {

    public int maxComponents(int n, int[][] edges, int[] values, int k) {
        // Build the tree using an adjacency list
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        // Perform DFS to calculate subtree sums and count valid components
        int[] result = new int[1];
        dfs(0, -1, tree, values, k, result);
        return result[0];
    }

    private int dfs(int node, int parent, List<List<Integer>> tree, int[] values, int k, int[] result) {
        int sum = values[node];
        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) {
                sum += dfs(neighbor, node, tree, values, k, result);
            }
        }
        if (sum % k == 0) {
            result[0]++;
            return 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxComponentsInValidSplit solution = new MaxComponentsInValidSplit();

        int n1 = 5;
        int[][] edges1 = {{0, 2}, {1, 2}, {1, 3}, {2, 4}};
        int[] values1 = {1, 8, 1, 4, 4};
        int k1 = 6;
        System.out.println(solution.maxComponents(n1, edges1, values1, k1)); // Output: 2

        int n2 = 7;
        int[][] edges2 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int[] values2 = {3, 0, 6, 1, 5, 2, 1};
        int k2 = 3;
        System.out.println(solution.maxComponents(n2, edges2, values2, k2)); // Output: 3
    }
}