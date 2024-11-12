package Trees.QandA;

import Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HeightOrDepthOfATree {

    /**
     * Calculates the maximum depth (or height) of a binary tree recursively.
     *
     * @param root The root node of the binary tree.
     * @return The maximum depth of the binary tree.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int maxDepthRecursive(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        // Recursively calculate the depth of the left and right subtrees
        int leftDepth = maxDepthRecursive(root.left);
        int rightDepth = maxDepthRecursive(root.right);

        // Return the greater depth plus one for the current node
        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }

    /**
     * Calculates the maximum depth (or height) of a binary tree iteratively.
     *
     * @param root The root node of the binary tree.
     * @return The maximum depth of the binary tree.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int maxDepthIterative(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        // Use a stack to traverse the tree
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(root);
        int maxDepth = 0;
        BinaryTreeNode prev = null;

        // Iterate until the stack is empty
        while (!stack.isEmpty()) {
            BinaryTreeNode current = stack.peek();

            // Traverse down the tree
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                }
            } else if (current.left == prev) { // Traverse up the tree from the left
                if (current.right != null) {
                    stack.push(current.right);
                }
            } else { // Traverse up the tree from the right
                stack.pop();
            }

            prev = current;

            // Update the maximum depth
            if (stack.size() > maxDepth) {
                maxDepth = stack.size();
            }
        }

        return maxDepth;
    }

    /**
     * Calculates the minimum depth (or height) of a binary tree.
     *
     * @param root The root node of the binary tree.
     * @return The minimum depth of the binary tree.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int minDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        // Use a queue to traverse the tree level by level
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null);
        int depth = 1;

        // Iterate until the queue is empty
        while (!q.isEmpty()) {
            BinaryTreeNode currentNode = q.poll();

            if (currentNode != null) {
                // Check if the current node is a leaf node
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }

                // Add the left and right children to the queue
                if (currentNode.left != null) {
                    q.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.offer(currentNode.right);
                }
            } else {
                // Increment the depth when a level is fully traversed
                if (!q.isEmpty()) {
                    depth++;
                    q.offer(null);
                }
            }
        }

        return depth;
    }
}