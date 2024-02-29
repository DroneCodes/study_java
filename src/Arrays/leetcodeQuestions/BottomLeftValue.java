package Arrays.leetcodeQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class BottomLeftValue {
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
         * This function finds the leftmost value in the last row of a binary tree.
         * It uses a breadth-first search (BFS) approach, traversing the tree level by level from right to left.
         * The last node visited in each level is the leftmost node.
         * The last visited node when all levels have been visited is the leftmost node in the last row.
         *
         * @param root The root of the binary tree.
         * @return The leftmost value in the last row of the tree.
         */
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int leftmost = root.val;

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                leftmost = node.val;
            }

            return leftmost;
        }
}
