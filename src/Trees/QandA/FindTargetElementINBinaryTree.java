package Trees.QandA;

import Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindTargetElementINBinaryTree {

    /**
     * Recursively finds the target element in the binary tree.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param root The root node of the binary tree.
     * @param target The target element to find.
     * @return True if the target element is found, otherwise false.
     */
    public static boolean findTargetRecursive(BinaryTreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.getData() == target) {
            return true;
        }

        return findTargetRecursive(root.getLeft(), target) || findTargetRecursive(root.getRight(), target);
    }

    public static boolean findTargetBST(BinaryTreeNode root, int target) {
    if (root == null) {
        return false;
    }
    if (root.getData() == target) {
        return true;
    }

    if (target < root.getData()) {
        return findTargetBST(root.getLeft(), target);
    } else {
        return findTargetBST(root.getRight(), target);
    }
}

    /**
     * Iteratively finds the target element in the binary tree using a queue.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param root The root node of the binary tree.
     * @param target The target element to find.
     * @return True if the target element is found, otherwise false.
     */
    public static boolean findTargetIterative(BinaryTreeNode root, int target) {
        if (root == null) {
            return false;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();
            if (temp.getData() == target) {
                return true;
            }
            if (temp != null) {
                if (temp.getLeft() != null) {
                    q.offer(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    q.offer(temp.getRight());
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.setLeft(new BinaryTreeNode(2));
        root.setRight(new BinaryTreeNode(3));
        root.getLeft().setLeft(new BinaryTreeNode(4));
        root.getLeft().setRight(new BinaryTreeNode(5));
        root.getRight().setLeft(new BinaryTreeNode(6));
        root.getRight().setRight(new BinaryTreeNode(7));

        System.out.println(findTargetRecursive(root, 5)); // true
        System.out.println(findTargetIterative(root, 7)); // false
    }
}