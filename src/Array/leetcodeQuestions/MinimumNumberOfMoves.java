package Array.leetcodeQuestions;

import java.util.Arrays;

public class MinimumNumberOfMoves {
    /**
     * This method calculates the minimum number of moves required to move each student to a seat.
     * The method uses a greedy approach to solve the problem.
     * It sorts both the seats and students arrays and then calculates the absolute difference between each student's position and the seat's position.
     * The total of these differences is the minimum number of moves required.
     *
     * @param seats    An array of integers representing the positions of the seats.
     * @param students An array of integers representing the positions of the students.
     * @return The minimum number of moves required to move each student to a seat.
     */
    public int minMovesToSeat(int[] seats, int[] students) {
        // Sort the seats array
        Arrays.sort(seats);
        // Sort the students array
        Arrays.sort(students);
        int moves = 0;
        // Iterate over each student
        for (int i = 0; i < seats.length; i++) {
            // Calculate the absolute difference between the student's position and the seat's position
            // and add it to the total number of moves
            moves += Math.abs(seats[i] - students[i]);
        }
        // Return the total number of moves
        return moves;
    }
}