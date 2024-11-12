package Trees.QandA;

import Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestNodeInABinaryTree {

    /**
     * Finds the deepest node in a binary tree.
     *
     * @param root The root node of the binary tree.
     * @return The deepest node in the binary tree.
     */
    public BinaryTreeNode deepestNode(BinaryTreeNode root) {
        BinaryTreeNode temp = null;
        if (root == null) {
            return null;
        }

        // Use a queue to perform level-order traversal
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);

        // Iterate until the queue is empty
        while (!q.isEmpty()) {
            // Poll the next node from the queue
            temp = q.poll();

            // Add the left child to the queue if it exists
            if (temp.getLeft() != null) {
                q.offer(temp.getLeft());
            }

            // Add the right child to the queue if it exists
            if (temp.right != null) {
                q.offer(temp.right);
            }
        }

        // Return the last node processed, which is the deepest node
        return temp;
    }
}