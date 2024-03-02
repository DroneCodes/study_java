package Arrays.leetcodeQuestions;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * To solve this problem, we can use a breadth-first search (BFS) approach, similar to the one used in the BottomLeftValue class. We will traverse the tree level by level, checking the conditions for each level. We will use a queue to keep track of the nodes at each level. For each level, we will check if the values of the nodes meet the conditions for that level. If all levels meet the conditions, we return true. Otherwise, we return false.
 *
 * This class represents a binary tree that can be checked if it is an Even-Odd tree.
 * An Even-Odd tree meets the following conditions:
 * - The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
 * - For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
 * - For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
 */
public class EvenOddTree {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * This function checks if a binary tree is an Even-Odd tree.
     *
     * @param root The root of the binary tree.
     * @return true if the binary tree is Even-Odd, otherwise false.
     */
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val % 2 == level % 2 ||
                        (level % 2 == 0 && node.val <= prev) ||
                        (level % 2 == 1 && node.val >= prev)) {
                    return false;
                }
                prev = node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
            prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return true;
    }
}