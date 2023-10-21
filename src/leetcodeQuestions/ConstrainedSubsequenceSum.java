package leetcodeQuestions;

import java.util.ArrayDeque;

public class ConstrainedSubsequenceSum {
    public int constrainedSubsetSum(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque();
        int[] sum = new int[nums.length];
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = nums[i];
            if (!deque.isEmpty()) {
                sum[i] += sum[deque.peekFirst()];
            }

            res = Math.max(res, sum[i]);

            if (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && sum[i] > sum[deque.peekLast()]) {
                deque.pollLast();
            }

            if (sum[i] > 0) {
                deque.offerLast(i);
            }
        }

        return res;
    }
}
