package Array.leetcodeQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to find the intersection of two arrays.
 * The intersection of two arrays is a list of numbers that appear in both arrays.
 * Each number in the intersection should appear as many times as it shows in both arrays.
 */
public class IntersectionOfTwoArrays2 {

    /**
     * This method is used to find the intersection of two arrays.
     * @param nums1 The first input array.
     * @param nums2 The second input array.
     * @return int[] This returns an array of numbers that appear in both input arrays.
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // Create a map to store the count of each number in the first array
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Create a list to store the intersection
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            // If the number is in the map, add it to the list and decrease its count in the map
            if (map.containsKey(num)) {
                list.add(num);
                map.put(num, map.get(num) - 1);
                // If the count becomes 0, remove the number from the map
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        // Convert the list to an array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        // Return the result
        return result;
    }
}