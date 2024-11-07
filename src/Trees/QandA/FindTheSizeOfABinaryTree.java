package Trees.QandA;

import Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheSizeOfABinaryTree {

    /**
     * Recursively finds the size of the binary tree.
     *
     * @param root The root node of the binary tree.
     * @return The size of the binary tree.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int sizeofBinaryTreeRecursive(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSize = root.left == null ? 0 : sizeofBinaryTreeRecursive(root.left);
        int rightSize = root.right == null ? 0 : sizeofBinaryTreeRecursive(root.right);
        return 1 + leftSize + rightSize;
    }

    /**
     * Iteratively finds the size of the binary tree using a queue.
     *
     * @param root The root node of the binary tree.
     * @return The size of the binary tree.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int sizeofBinaryTreeIterative(BinaryTreeNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();
            count++;
            if (temp.left != null) {
                q.offer(temp.left);
            }
            if (temp.right != null) {
                q.offer(temp.right);
            }
        }
        return count;
    }
}