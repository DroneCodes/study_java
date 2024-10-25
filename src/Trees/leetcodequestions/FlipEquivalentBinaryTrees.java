package Trees.leetcodequestions;

/**
 * This class provides a method to determine if two binary trees are flip equivalent.
 * Flip equivalent means that one tree can be transformed into the other by a series of flip operations.
 * A flip operation consists of swapping the left and right child subtrees of any node.
 */
public class FlipEquivalentBinaryTrees {

    /**
     * Determines if two binary trees are flip equivalent.
     *
     * @param root1 the root of the first binary tree
     * @param root2 the root of the second binary tree
     * @return true if the two trees are flip equivalent, false otherwise
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // If both nodes are null, they are equivalent
        if (root1 == null && root2 == null) {
            return true;
        }

        // If one node is null and the other is not, or if the values of the nodes are different, they are not equivalent
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        // Recursively check if the children are flip equivalent in either the original or flipped order
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
            (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}