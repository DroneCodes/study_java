package Array.leetcodeQuestions;

import java.util.PriorityQueue;

public class MaximumAveragePassRatio {

    /**
     * Calculates the maximum possible average pass ratio after assigning extra students.
     *
     * @param classes the 2D array representing the number of passing and total students in each class
     * @param extraStudents the number of extra students to be assigned
     * @return the maximum possible average pass ratio
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double currentRatio = (double) pass / total;
            double potentialIncrease = (double) (pass + 1) / (total + 1) - currentRatio;
            pq.offer(new double[]{potentialIncrease, pass, total});
        }

        while (extraStudents > 0) {
            double[] top = pq.poll();
            double potentialIncrease = top[0];
            int pass = (int) top[1];
            int total = (int) top[2];
            pass++;
            total++;
            double newRatio = (double) pass / total;
            double newPotentialIncrease = (double) (pass + 1) / (total + 1) - newRatio;
            pq.offer(new double[]{newPotentialIncrease, pass, total});
            extraStudents--;
        }

        double totalRatio = 0;
        int n = classes.length;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            totalRatio += (double) pass / total;
        }

        return totalRatio / n;
    }

    public static void main(String[] args) {
        MaximumAveragePassRatio solution = new MaximumAveragePassRatio();

        int[][] classes1 = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents1 = 2;
        System.out.println("Maximum average pass ratio (Test case 1): " + solution.maxAverageRatio(classes1, extraStudents1)); // Expected output: 0.78333

        int[][] classes2 = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        int extraStudents2 = 4;
        System.out.println("Maximum average pass ratio (Test case 2): " + solution.maxAverageRatio(classes2, extraStudents2)); // Expected output: 0.53485
    }
}