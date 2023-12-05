package leetcodeQuestions;

public class MinimumTimeVisiting {

    public static int minTimeToVisitAllPoints(int[][] points) {
        int minTime = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            int x2 = points[i + 1][0];
            int y2 = points[i + 1][1];
            minTime += Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
        return minTime;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(minTimeToVisitAllPoints(points));
    }


}
