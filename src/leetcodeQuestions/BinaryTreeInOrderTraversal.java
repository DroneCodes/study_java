package leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrderTraversal {

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

    // Method for in-order traversal of a binary tree
    public List<Integer> inorderTraversal(TreeNode root) {
        // Create a list to store the values of the nodes
        List<Integer> result = new ArrayList<>();
        // Call the helper method to perform the in-order traversal and fill the result list
        helper(root, result);
        // Return the result list
        return result;
    }

    // Helper method for in-order traversal of a binary tree
    private void helper(TreeNode root, List<Integer> result) {
        // If the root is not null, perform the in-order traversal
        if (root != null) {
            // If the left child is not null, recursively call the helper method on the left subtree
            if (root.left != null) {
                helper(root.left, result);
            }
            // Add the value of the root to the result list
            result.add(root.val);
            // If the right child is not null, recursively call the helper method on the right subtree
            if (root.right != null) {
                helper(root.right, result);
            }
        }
    }
}

/*
     In this code, the helper method is a recursive function that performs the in-order traversal. It first checks if the root is not null. If the root is null, it simply returns as there's nothing to add to the result list. If the root is not null, it recursively calls the helper method on the left subtree, adds the value of the root to the result list, and then recursively calls the helper method on the right subtree. This ensures that the values are added to the result list in the order of left node, root node, and right node.
 */
