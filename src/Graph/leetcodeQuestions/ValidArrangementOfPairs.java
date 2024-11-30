package Graph.leetcodeQuestions;

import java.util.*;

public class ValidArrangementOfPairs {

    /**
     * Finds a valid arrangement of pairs.
     *
     * @param pairs the input pairs
     * @return a valid arrangement of pairs
     */
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        // Build the graph and calculate in-degrees and out-degrees
        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];
            graph.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        // Find the start node for the Eulerian path
        int startNode = pairs[0][0];
        for (int node : outDegree.keySet()) {
            if (outDegree.get(node) - inDegree.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }

        // Perform DFS to find the Eulerian path
        List<int[]> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (graph.containsKey(node) && !graph.get(node).isEmpty()) {
                stack.push(graph.get(node).remove(graph.get(node).size() - 1));
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.add(new int[]{stack.peek(), node});
                }
            }
        }

        // Convert the result list to an array
        Collections.reverse(result);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        ValidArrangementOfPairs solution = new ValidArrangementOfPairs();

        int[][] pairs1 = {{5, 1}, {4, 5}, {11, 9}, {9, 4}};
        System.out.println("Valid arrangement (Test case 1): " + Arrays.deepToString(solution.validArrangement(pairs1)));

        int[][] pairs2 = {{1, 3}, {3, 2}, {2, 1}};
        System.out.println("Valid arrangement (Test case 2): " + Arrays.deepToString(solution.validArrangement(pairs2)));

        int[][] pairs3 = {{1, 2}, {1, 3}, {2, 1}};
        System.out.println("Valid arrangement (Test case 3): " + Arrays.deepToString(solution.validArrangement(pairs3)));
    }
}