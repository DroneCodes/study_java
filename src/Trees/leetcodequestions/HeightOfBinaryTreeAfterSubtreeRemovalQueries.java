package Trees.leetcodequestions;

import java.util.*;

/**
 * This class provides methods to handle queries on a binary tree where each query involves removing a subtree
 * and calculating the height of the remaining tree.
 */
public class HeightOfBinaryTreeAfterSubtreeRemovalQueries {

    /**
     * Depth-first search (DFS) to calculate the height and level of each node.
     *
     * @param root the root of the binary tree
     * @param heights a map to store the height and level of each node
     * @param level the current level of the node
     * @return the height of the current node
     */
    int dfs(TreeNode root, Map<Integer, int[]> heights, int level) {
        if (root == null) return 0;
        heights.put(root.val, new int[]{1 + Math.max(dfs(root.left, heights, level + 1), dfs(root.right, heights, level + 1)), level});
        return heights.get(root.val)[0];
    }

    /**
     * Handles the queries by removing the specified subtree, calculating the height, and restoring the tree.
     *
     * @param root the root of the binary tree
     * @param queries an array of values representing the roots of subtrees to remove
     * @return an array of heights of the tree after each query
     */
    public int[] treeQueries(TreeNode root, int[] queries) {
        // Map for storing height and level of each node
        Map<Integer, int[]> heights = new HashMap<>();
        // Map for storing heights at each level
        Map<Integer, PriorityQueue<Integer>> levelOrderHeights = new HashMap<>();

        // DFS to calculate the height and level of each node
        dfs(root, heights, 0);

        int rootHeight = heights.get(root.val)[0];
        for (int i = 0; i < heights.get(root.val)[0]; ++i)
            levelOrderHeights.put(i, new PriorityQueue<>((a, b) -> Integer.compare(b, a)));

        // BFS to calculate heights at each level
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- != 0) {
                TreeNode node = q.poll();
                levelOrderHeights.get(level).add(heights.get(node.val)[0]);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            level++;
        }

        int[] ans = new int[queries.length];
        int i = 0;
        for (int query : queries) {
            int height = heights.get(query)[0];
            int curlevel = heights.get(query)[1];
            PriorityQueue<Integer> curheights = levelOrderHeights.get(curlevel);

            // If height of the deleted node is not the maximum at that level, then it will have no impact on the root height
            if (height != curheights.peek()) ans[i++] = rootHeight - 1;

            // If it is the only node at that level, means height of the root will get reduced by height of the node subtree
            else if (curheights.size() == 1) ans[i++] = rootHeight - height - 1;

            // If deleted node has the max height at that level then the height of the root get reduced by the difference of max and second max height at that level
            else {
                int curHeight = curheights.poll();
                int res = rootHeight - curHeight + curheights.peek();
                curheights.add(curHeight);
                ans[i++] = res - 1;
            }
        }
        return ans;
    }
}