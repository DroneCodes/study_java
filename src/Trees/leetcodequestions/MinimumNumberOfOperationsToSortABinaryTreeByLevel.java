package Trees.leetcodequestions;

import java.util.*;

public class MinimumNumberOfOperationsToSortABinaryTreeByLevel {

    /**
     * Calculates the minimum number of operations needed to make the values at each level of the binary tree
     * sorted in strictly increasing order.
     *
     * @param root The root of the binary tree.
     * @return The minimum number of operations needed.
     */
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int operations = 0;

        // Perform level-order traversal to collect nodes at each level
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            operations += minSwapsToSort(currentLevel);
        }

        return operations;
    }

    /**
     * Calculates the minimum number of swaps required to sort the given list in strictly increasing order.
     *
     * @param level The list of integers representing the values at a level of the binary tree.
     * @return The minimum number of swaps required to sort the list.
     */
    private int minSwapsToSort(List<Integer> level) {
        int n = level.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = level.get(i);
        }

        // Create a sorted copy of the array
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // Create a map to store the index of each value in the sorted array
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(sortedArr[i], i);
        }

        // Count the minimum number of swaps to sort the array
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i] == sortedArr[i]) continue;

            int cycleSize = 0;
            int x = i;
            while (!visited[x]) {
                visited[x] = true;
                x = indexMap.get(arr[x]);
                cycleSize++;
            }

            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsToSortABinaryTreeByLevel solution = new MinimumNumberOfOperationsToSortABinaryTreeByLevel();

        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(5);
        root.left.left.left = null;
        root.left.left.right = null;
        root.left.right.left = null;
        root.left.right.right = null;
        root.right.left.left = new TreeNode(9);
        root.right.left.right = null;
        root.right.right.left = new TreeNode(10);
        root.right.right.right = null;

        System.out.println(solution.minimumOperations(root)); // Output: 3
    }
}