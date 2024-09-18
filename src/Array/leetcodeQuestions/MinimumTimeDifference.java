package Array.leetcodeQuestions;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutes = new int[n];
        for (int i = 0; i < n; i++) {
            String[] time = timePoints.get(i).split(":");
            minutes[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }
        Arrays.sort(minutes);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, minutes[i] - minutes[i - 1]);
        }
        minDiff = Math.min(minDiff, 1440 - minutes[n - 1] + minutes[0]);
        return minDiff;
    }

    public static void main(String[] args) {
        MinimumTimeDifference obj = new MinimumTimeDifference();
        List<String> timePoints = Arrays.asList("23:59", "00:00");
        System.out.println(obj.findMinDifference(timePoints));
    }
}
