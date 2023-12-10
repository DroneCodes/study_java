package leetcodeQuestions;

public class ConstructStringFromBinaryTree {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructor for creating a new tree node without any children
        TreeNode() {
        }

        // Constructor for creating a new tree node with a specific value
        TreeNode(int val) {
            this.val = val;
        }

        // Constructor for creating a new tree node with a specific value and left and right children
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Method for converting a binary tree to a string
    public static String tree2str(TreeNode root) {
        // If the root is null, return an empty string
        if (root == null) return "";
        // If the root has no children, return the value of the root as a string
        if (root.left == null && root.right == null) return root.val + "";
        // If the root has no right child, return the value of the root and the string representation of the left child
        if (root.right == null) return root.val + "(" + tree2str(root.left) + ")";
        // If the root has both children, return the value of the root and the string representations of both children
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }

    // Main method for testing the tree2str method
    public static void main(String[] args) {
        // Create a new binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        // Print the string representation of the binary tree
        System.out.println(tree2str(root));
    }
}