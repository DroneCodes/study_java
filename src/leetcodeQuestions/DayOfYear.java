package leetcodeQuestions;

/**
 * This class provides a method to find the day number of the year for a given date.
 *
 * To solve this problem, we can follow these steps:
 * Parse the input string to extract the year, month, and day.
 * Create an array to store the number of days in each month. For February, check if the year is a leap year. If it is, set the number of days to 29, otherwise set it to 28.
 * Iterate from 0 to the month - 2, and sum up the number of days in each month.
 * Add the day to the sum.
 * Return the sum.
 *
 */
public class DayOfYear {

    /**
     * This method returns the day number of the year for a given date.
     *
     * @param date The date in the format YYYY-MM-DD.
     * @return The day number of the year.
     */
    public static int dayOfYear(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            daysInMonth[1] = 29;
        }

        int dayOfYear = 0;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonth[i];
        }
        dayOfYear += day;

        return dayOfYear;
    }

    /**
     * The main method that tests the dayOfYear method with sample inputs.
     *
     * @param args The command line arguments. Not used in this method.
     */
    public static void main(String[] args) {
        System.out.println(dayOfYear("2019-01-09"));  // Output: 9
        System.out.println(dayOfYear("2019-02-10")); // Output: 41
    }
}
