package Array.leetcodeQuestions;

import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    /**
     * List to store the events in the calendar.
     * Each event is represented as an array of two integers [start, end).
     */
    private List<int[]> calendar;

    /**
     * Initializes the calendar object.
     * Creates an empty list to store the events.
     */
    public MyCalendar() {
        calendar = new ArrayList<>();
    }

    /**
     * Books a new event in the calendar.
     * Checks if the new event overlaps with any existing event.
     * If no overlap is found, adds the new event to the calendar and returns true.
     * If an overlap is found, returns false.
     *
     * @param start the start time of the event (inclusive)
     * @param end   the end time of the event (exclusive)
     * @return true if the event can be added without causing a double booking, false otherwise
     */
    public boolean book(int start, int end) {
        for (int[] event : calendar) {
            if (start < event[1] && end > event[0]) {
                return false; // Overlap detected
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // return True
        System.out.println(myCalendar.book(15, 25)); // return False
        System.out.println(myCalendar.book(20, 30)); // return True
    }
}