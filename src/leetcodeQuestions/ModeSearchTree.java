package leetcodeQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class treeNode {
      int val;
      treeNode left;
      treeNode right;
      treeNode() {}
      treeNode(int val) { this.val = val; }
      treeNode(int val, treeNode left, treeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class ModeSearchTree {

    public int[] findMode(treeNode root) {

        // First find the max frequency
        // Then find all the nodes with that frequency
        // Return the list of nodes

        // Base case
        if (root == null) {
            return new int[]{};
        }

        // First find the max frequency
        // Then find all the nodes with that frequency
        // Return the list of nodes

        // Base case
        if (root == null) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        findModeHelper(root, map);

        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }

        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }
        return result;

    }

    public void findModeHelper(treeNode root, Map<Integer, Integer> map) {

        if (root == null) {
            return;
        }

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);

        findModeHelper(root.left, map);
        findModeHelper(root.right, map);
    }
}
