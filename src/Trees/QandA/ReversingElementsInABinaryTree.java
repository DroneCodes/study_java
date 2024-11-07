package Trees.QandA;

import Trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversingElementsInABinaryTree {

    /**
     * Performs a level order traversal of the binary tree in reverse order.
     * The nodes are visited level by level from left to right, but the output is in reverse order.
     *
     * @param root The root node of the binary tree.
     */
    public static void levelOrderTraversalInReverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();
            if (temp.getLeft() != null) {
                q.offer(temp.getLeft());
            }
            if (temp.getRight() != null) {
                q.offer(temp.getRight());
            }
            stack.push(temp);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().getData() + " ");
        }
    }
}