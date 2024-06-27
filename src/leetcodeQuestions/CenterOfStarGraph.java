package leetcodeQuestions;

/**
 * This class is used to find the center of a star graph.
 * A star graph is a graph where there is one center node and all other nodes are connected to this center node.
 */
public class CenterOfStarGraph {

    /**
     * This method is used to find the center of a star graph.
     * The center of a star graph is the node that has the most edges connected to it.
     * @param edges This is a 2D array where each sub-array represents an edge in the graph. The two elements of the sub-array are the two nodes that the edge connects.
     * @return int This returns the center node of the star graph. If no center node is found, it returns -1.
     */
    public static int findCenter(int[][] edges) {
        int[] count = new int[edges.length + 2];
        for (int i = 0; i < edges.length; i++) {
            count[edges[i][0]]++;
            count[edges[i][1]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == edges.length) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This is the main method which makes use of findCenter method.
     * @param args Unused.
     */
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(findCenter(edges));
    }
}