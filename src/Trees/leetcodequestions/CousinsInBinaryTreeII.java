package Trees.leetcodequestions;

/**
 * This class provides a method to replace the value of each node in a binary tree
 * with the sum of all its cousins' values. Two nodes of a binary tree are cousins
 * if they have the same depth with different parents.
 */

public class CousinsInBinaryTreeII {
    /**
     * Replaces the value of each node in the tree with the sum of all its cousins' values.
     *
     * @param root The root of the binary tree.
     * @return The root of the modified binary tree.
     */
    public TreeNode replaceValueInTree(TreeNode root) {
        dfs(new TreeNode[] {root});
        root.val = 0;
        return root;
    }

    /**
     * Helper method to perform a depth-first search (DFS) on the tree and calculate
     * the sum of cousins' values for each node.
     *
     * @param arr An array of TreeNode objects representing the current level of nodes.
     */

    private void dfs(TreeNode[] arr) {
        if (arr.length == 0) return;

        int sum = 0;
        for (TreeNode node : arr) {
            if (node == null) continue;
            if (node.left != null) sum += node.left.val;
            if (node.right != null) sum += node.right.val;
        }

        TreeNode[] childArr = new TreeNode[arr.length * 2];
        int index = 0;

        for (TreeNode node : arr) {
            int curSum = 0;
            if (node.left != null) curSum += node.left.val;
            if (node.right != null) curSum += node.right.val;

            if (node.left != null) {
                node.left.val = sum - curSum;
                childArr[index++] = node.left;
            }
            if (node.right != null) {
                node.right.val = sum - curSum;
                childArr[index++] = node.right;
            }
        }

        dfs(java.util.Arrays.copyOf(childArr, index));
    }
}