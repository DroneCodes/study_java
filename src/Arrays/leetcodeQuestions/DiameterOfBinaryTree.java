package Arrays.leetcodeQuestions;

public class DiameterOfBinaryTree {
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
     * To solve this problem, we can use a Depth-First Search (DFS) approach. We will create a helper function depth that calculates the depth of a node. The depth of a node is the number of edges from the node to the deepest leaf. The diameter of a tree is the maximum value of depth(left child) + depth(right child) for each node.
     * We will use a global variable diameter to keep track of the maximum diameter found so far. We will update the diameter whenever we find a new maximum value of depth(left child) + depth(right child).
     * The depth function will return the depth of a node. If the node is null, the depth will be 0. Otherwise, the depth will be 1 + the maximum of the depth of the left child and the depth of the right child.
     * The diameterOfBinaryTree function will call the depth function on the root node and return the value of the diameter variable.
     * @param root The root of the binary tree.
     * @return The diameter of the binary tree.
     *
     */
    int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        depth(root);
        return diameter;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
