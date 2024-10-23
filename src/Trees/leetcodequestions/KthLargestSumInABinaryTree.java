package Trees.leetcodequestions;

import java.util.*;

public class KthLargestSumInABinaryTree {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            while (size > 0) {
                TreeNode temp = q.poll();
                sum += temp.val;
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
                size--;
            }
            pq.add(sum);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.size() < k ? -1 : pq.peek();
    }

    public static void main(String[] args) {
        KthLargestSumInABinaryTree solution = new KthLargestSumInABinaryTree();

        // Test case 1
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(9);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(1);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(7);
        root1.left.left.left = new TreeNode(4);
        root1.left.left.right = new TreeNode(6);
        int k1 = 2;
        System.out.println(solution.kthLargestLevelSum(root1, k1)); // Output: 13

        // Test case 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        int k2 = 1;
        System.out.println(solution.kthLargestLevelSum(root2, k2)); // Output: 3
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}