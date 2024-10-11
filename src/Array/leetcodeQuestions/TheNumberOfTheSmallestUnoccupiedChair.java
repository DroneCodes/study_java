package Array.leetcodeQuestions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheNumberOfTheSmallestUnoccupiedChair {
    /**
     * Finds the chair number that the target friend will sit on.
     *
     * @param times the 2D array of arrival and leaving times of friends
     * @param targetFriend the index of the target friend
     * @return the chair number that the target friend will sit on
     */
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int targetArrival = times[targetFriend][0];

        // Create an array of events (arrival and departure)
        int[][] events = new int[2 * n][2];
        for (int i = 0; i < n; i++) {
            events[2 * i] = new int[]{times[i][0], i, 1}; // Arrival event
            events[2 * i + 1] = new int[]{times[i][1], i, 0}; // Departure event
        }

        // Sort events by time, prioritize departures over arrivals if times are the same
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[2] - b[2] : a[0] - b[0]);

        // Priority queue for available chairs
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.add(i);
        }

        // Priority queue for friends leaving the party
        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Simulate the process
        for (int[] event : events) {
            int time = event[0];
            int friend = event[1];
            int type = event[2];

            if (type == 1) { // Arrival
                int chair = availableChairs.poll();
                if (friend == targetFriend) {
                    return chair;
                }
                leavingQueue.add(new int[]{times[friend][1], chair});
            } else { // Departure
                int[] leaving = leavingQueue.poll();
                availableChairs.add(leaving[1]);
            }
        }

        return -1; // This line should never be reached
    }

    public static void main(String[] args) {
        TheNumberOfTheSmallestUnoccupiedChair solution = new TheNumberOfTheSmallestUnoccupiedChair();

        // Test case 1
        int[][] times1 = {{1, 4}, {2, 3}, {4, 6}};
        int targetFriend1 = 1;
        System.out.println(solution.smallestChair(times1, targetFriend1)); // Output: 1

        // Test case 2
        int[][] times2 = {{3, 10}, {1, 5}, {2, 6}};
        int targetFriend2 = 0;
        System.out.println(solution.smallestChair(times2, targetFriend2)); // Output: 2
    }
}