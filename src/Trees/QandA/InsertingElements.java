package Trees.QandA;

import Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InsertingElements {

    /**
     * Inserts an element into the binary tree iteratively.
     *
     * @param root The root node of the binary tree.
     * @param data The data to be inserted.
     * @return The root node of the binary tree after insertion.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public BinaryTreeNode insertElementIterative(BinaryTreeNode root, int data) {
        if (root == null) {
            return null;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();
            if (temp != null) {
                if (temp.getLeft() != null) {
                    q.offer(temp.getLeft());
                } else {
                    temp.setLeft(new BinaryTreeNode(data));
                    return root;
                }
                if(temp.getRight() != null) {
                    q.offer(temp.getRight());
                } else {
                    temp.setRight(new BinaryTreeNode(data));
                    return root;
                }
            }
        }
        return root;
    }

    /**
     * Inserts an element into the binary tree recursively.
     *
     * @param root The root node of the binary tree.
     * @param data The data to be inserted.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     */
    public void insertElementRecursive(BinaryTreeNode root, int data) {
        if (root == null) {
            root = new BinaryTreeNode(data);
        } else {
            insertHelper(root, data);
        }
    }

    /**
     * Helper method to insert an element into the binary tree recursively.
     *
     * @param root The current node in the binary tree.
     * @param data The data to be inserted.
     */
    private void insertHelper(BinaryTreeNode root, int data) {
        if (root.data >= data) { // This check is not compulsory, but it is good to have it.
            if (root.left == null) {
                root.left = new BinaryTreeNode(data);
            } else {
                insertHelper(root.left, data);
            }
        } else {
            if (root.right == null) {
                root.right = new BinaryTreeNode(data);
            } else {
                insertHelper(root.right, data);
            }
        }
    }
}