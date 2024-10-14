package Array.leetcodeQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists {
    /**
     * Finds the smallest range that includes at least one number from each of the k lists.
     *
     * @param nums the 2D array of k lists of sorted integers
     * @return the smallest range as an array of two integers
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        // Priority queue to keep track of the smallest elements from each list
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        int max = Integer.MIN_VALUE;

        // Initialize the heap with the first element of each list
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            minHeap.add(new Element(value, i, 0));
            max = Math.max(max, value);
        }

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        // Expand the window
        while (minHeap.size() == nums.size()) {
            Element minElement = minHeap.poll();
            int currentRangeStart = minElement.value;
            int currentRangeEnd = max;

            // Update the range if the current window is smaller
            if (currentRangeEnd - currentRangeStart < rangeEnd - rangeStart) {
                rangeStart = currentRangeStart;
                rangeEnd = currentRangeEnd;
            }

            // Add the next element from the same list to the heap
            if (minElement.index + 1 < nums.get(minElement.listIndex).size()) {
                int nextValue = nums.get(minElement.listIndex).get(minElement.index + 1);
                minHeap.add(new Element(nextValue, minElement.listIndex, minElement.index + 1));
                max = Math.max(max, nextValue);
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }

    // Helper class to store the value and its position in the list
    private static class Element {
        int value;
        int listIndex;
        int index;

        Element(int value, int listIndex, int index) {
            this.value = value;
            this.listIndex = listIndex;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        SmallestRangeCoveringElementsFromKLists solution = new SmallestRangeCoveringElementsFromKLists();

        // Test case 1
        List<List<Integer>> nums1 = Arrays.asList(
            Arrays.asList(4, 10, 15, 24, 26),
            Arrays.asList(0, 9, 12, 20),
            Arrays.asList(5, 18, 22, 30)
        );
        System.out.println(Arrays.toString(solution.smallestRange(nums1))); // Output: [20, 24]

        // Test case 2
        List<List<Integer>> nums2 = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(1, 2, 3),
            Arrays.asList(1, 2, 3)
        );
        System.out.println(Arrays.toString(solution.smallestRange(nums2))); // Output: [1, 1]
    }
}