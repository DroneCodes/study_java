package Graph.leetcodeQuestions;

public class FindChampionII {

    /**
     * Finds the champion team in the tournament.
     *
     * @param n the number of teams
     * @param edges the edges representing the DAG
     * @return the champion team if there is a unique champion, otherwise -1
     */
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];

        // Calculate in-degrees of each node
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }

        int champion = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (champion == -1) {
                    champion = i;
                } else {
                    return -1; // More than one node with zero in-degrees
                }
            }
        }

        return champion;
    }

    /**
     * Main method to test the findChampion method with different examples.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        FindChampionII solution = new FindChampionII();

        int n1 = 3;
        int[][] edges1 = {{0, 1}, {1, 2}};
        System.out.println(solution.findChampion(n1, edges1)); // Output: 0

        int n2 = 4;
        int[][] edges2 = {{0, 2}, {1, 3}, {1, 2}};
        System.out.println(solution.findChampion(n2, edges2)); // Output: -1
    }
}