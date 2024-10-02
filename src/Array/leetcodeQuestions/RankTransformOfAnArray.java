package Array.leetcodeQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfAnArray {
    /**
     * Replaces each element in the array with its rank.
     *
     * @param arr the array of integers
     * @return the array with each element replaced by its rank
     */
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        RankTransformOfAnArray solution = new RankTransformOfAnArray();

        int[] arr1 = {40, 10, 20, 30};
        System.out.println(Arrays.toString(solution.arrayRankTransform(arr1))); // Output: [4, 1, 2, 3]

        int[] arr2 = {100, 100, 100};
        System.out.println(Arrays.toString(solution.arrayRankTransform(arr2))); // Output: [1, 1, 1]

        int[] arr3 = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        System.out.println(Arrays.toString(solution.arrayRankTransform(arr3))); // Output: [5, 3, 4, 2, 8, 6, 7, 1, 3]
    }
}
