package Trees.leetcodequestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindMinimumDiameterAfterMergingTwoTrees {

    /**
     * Calculates the minimum possible diameter of the resulting tree after connecting one node from the first tree
     * with another node from the second tree.
     *
     * @param edges1 The edges of the first tree.
     * @param edges2 The edges of the second tree.
     * @return The minimum possible diameter of the resulting tree.
     */
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // Calculate the number of nodes for each tree
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        // Build adjacency lists for both trees
        List<List<Integer>> adjList1 = buildAdjList(n, edges1);
        List<List<Integer>> adjList2 = buildAdjList(m, edges2);

        // Calculate the diameters of both trees
        int diameter1 = findDiameter(n, adjList1);
        int diameter2 = findDiameter(m, adjList2);

        // Calculate the longest path that spans across both trees
        int combinedDiameter = (int) Math.ceil(diameter1 / 2.0) + (int) Math.ceil(diameter2 / 2.0) + 1;

        // Return the maximum of the three possibilities
        return Math.max(Math.max(diameter1, diameter2), combinedDiameter);
    }

    /**
     * Builds the adjacency list for a tree.
     *
     * @param size  The number of nodes in the tree.
     * @param edges The edges of the tree.
     * @return The adjacency list of the tree.
     */
    private List<List<Integer>> buildAdjList(int size, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }

    /**
     * Finds the diameter of a tree.
     *
     * @param n       The number of nodes in the tree.
     * @param adjList The adjacency list of the tree.
     * @return The diameter of the tree.
     */
    private int findDiameter(int n, List<List<Integer>> adjList) {
        // First BFS to find the farthest node from an arbitrary node (e.g., 0)
        Pair firstBFS = findFarthestNode(n, adjList, 0);
        int farthestNode = firstBFS.getFirst();

        // Second BFS to find the diameter starting from the farthest node
        Pair secondBFS = findFarthestNode(n, adjList, farthestNode);
        return secondBFS.getSecond();
    }

    /**
     * Finds the farthest node from a given source node using BFS.
     *
     * @param n         The number of nodes in the tree.
     * @param adjList   The adjacency list of the tree.
     * @param sourceNode The starting node for BFS.
     * @return A pair containing the farthest node and the distance to it.
     */
    private Pair findFarthestNode(int n, List<List<Integer>> adjList, int sourceNode) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(sourceNode);
        visited[sourceNode] = true;

        int maximumDistance = 0, farthestNode = sourceNode;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentNode = queue.poll();
                farthestNode = currentNode;

                for (int neighbor : adjList.get(currentNode)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            if (!queue.isEmpty()) maximumDistance++;
        }
        return new Pair(farthestNode, maximumDistance);
    }

    /**
     * Simple Pair class for storing results of findFarthestNode function.
     */
    class Pair {
        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }
}