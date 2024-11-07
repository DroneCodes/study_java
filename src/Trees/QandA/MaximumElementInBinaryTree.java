package Trees.QandA;

import Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumElementInBinaryTree {
    /**
     * The idea is to traverse the tree in post order fashion and compare the data of the root with the maximum of the left and right subtree.
     * If the root data is greater than the maximum of the left and right subtree, then the root data will be the maximum element.
     * If the maximum of the left and right subtree is greater than the root data, then the maximum of the left and right subtree will be the maximum element.
     * The base case of the recursion is when the root is null, then the maximum element will be Integer.MIN_VALUE.
     * @param root
     * @return
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int maxElementRecursive(BinaryTreeNode root) {
        int max = Integer.MIN_VALUE;
        if (root != null) {
            int leftMax = maxElementRecursive(root.left);
            int rightMax = maxElementRecursive(root.right);

            if (leftMax > rightMax) {
                max = leftMax;
            } else {
                max = rightMax;
            }

            if (root.data > max) {
                max = root.data;
            }
        } else {
            return max;
        }
        return max;
    }


    /**
     * The idea is to traverse the tree in level order fashion using a queue.
     * The maximum element will be the maximum element found in the level order traversal.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param root
     * @return
     */
    public int maxElementIterative(BinaryTreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int max = Integer.MIN_VALUE;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();
            if (temp.getData() > max) {
                max = temp.getData();
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
        return max;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);

        MaximumElementInBinaryTree obj = new MaximumElementInBinaryTree();
        System.out.println(obj.maxElementRecursive(root));
        System.out.println(obj.maxElementIterative(root));
    }
}
