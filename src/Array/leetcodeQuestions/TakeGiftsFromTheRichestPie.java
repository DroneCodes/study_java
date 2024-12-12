package Array.leetcodeQuestions;

import java.util.PriorityQueue;
import java.util.Collections;

public class TakeGiftsFromTheRichestPie {

    /**
     * Returns the number of gifts remaining after k seconds.
     *
     * @param gifts the array of gifts in various piles
     * @param k the number of seconds
     * @return the number of gifts remaining after k seconds
     */
    public int remainingGifts(int[] gifts, int k) {
        // Create a max-heap (priority queue)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            maxHeap.add(gift);
        }

        // Perform the operation for k seconds
        for (int i = 0; i < k; i++) {
            int maxGifts = maxHeap.poll();
            int remainingGifts = (int) Math.floor(Math.sqrt(maxGifts));
            maxHeap.add(remainingGifts);
        }

        // Sum up the remaining gifts
        int totalGifts = 0;
        while (!maxHeap.isEmpty()) {
            totalGifts += maxHeap.poll();
        }

        return totalGifts;
    }

    public static void main(String[] args) {
        TakeGiftsFromTheRichestPie solution = new TakeGiftsFromTheRichestPie();

        int[] gifts1 = {25, 64, 9, 4, 100};
        int k1 = 4;
        System.out.println("Output (Test case 1): " + solution.remainingGifts(gifts1, k1)); // Expected output: 29

        int[] gifts2 = {1, 1, 1, 1};
        int k2 = 4;
        System.out.println("Output (Test case 2): " + solution.remainingGifts(gifts2, k2)); // Expected output: 4
    }
}
