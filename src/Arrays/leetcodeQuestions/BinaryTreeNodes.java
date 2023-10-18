package Arrays.leetcodeQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;

public class BinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        boolean[] hasParent = new boolean[n]; // Array to track nodes with parents
        int rootCount = 0; // Count of root nodes

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (hasParent[leftChild[i]]) {
                    return false; // Left child already has a parent
                }
                hasParent[leftChild[i]] = true;
            }
            if (rightChild[i] != -1) {
                if (hasParent[rightChild[i]]) {
                    return false; // Right child already has a parent
                }
                hasParent[rightChild[i]] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!hasParent[i]) {
                rootCount++;
                if (rootCount > 1) {
                    return false; // More than one root node
                }
                q.add(i);
            }
        }

        if (rootCount != 1) {
            return false; // No root node or more than one root node
        }

        while (!q.isEmpty()) {
            int currentNode = q.poll();

            if (hs.contains(currentNode)) {
                return false; // Cycle detected
            }

            hs.add(currentNode);

            if (leftChild[currentNode] != -1) {
                q.add(leftChild[currentNode]);
            }
            if (rightChild[currentNode] != -1) {
                q.add(rightChild[currentNode]);
            }
        }

        // Ensure that all nodes were visited and the binary tree is connected
        return hs.size() == n;
    }
}


