package Array.leetcodeQuestions;

public class SameTree {
    /**
     *
     * The function will be called SameTree and it will take two parameters, both of type TreeNode. TreeNode is a class that represents a node in a binary tree, which has an integer value and two children nodes (left and right).  Here is the pseudocode for the function:
     * If both trees are null, return true.
     * If one of the trees is null, return false.
     * If the values of the nodes are not equal, return false.
     * Recursively call SameTree on the left children of the two nodes and the right children of the two nodes.
     * If both recursive calls return true, return true. Otherwise, return false.
     *
     * Given the roots of two binary trees p and q, this function checks if they are the same or not.
     * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
     *
     * @param p The root of the first binary tree.
     * @param q The root of the second binary tree.
     * @return true if the two binary trees are the same, false otherwise.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}
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
}}