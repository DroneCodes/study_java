package Array.leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarII {
    private List<int[]> calendar;
    private List<int[]> overlaps;

    public MyCalendarII() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] event : overlaps) {
            if (start < event[1] && end > event[0]) {
                return false; // Triple booking detected
            }
        }
        for (int[] event : calendar) {
            if (start < event[1] && end > event[0]) {
                overlaps.add(new int[]{Math.max(start, event[0]), Math.min(end, event[1])});
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendarII myCalendarTwo = new MyCalendarII();
        System.out.println(myCalendarTwo.book(10, 20)); // return True
        System.out.println(myCalendarTwo.book(50, 60)); // return True
        System.out.println(myCalendarTwo.book(10, 40)); // return True
        System.out.println(myCalendarTwo.book(5, 15));  // return False
        System.out.println(myCalendarTwo.book(5, 10));  // return True
        System.out.println(myCalendarTwo.book(25, 55)); // return True
    }
}