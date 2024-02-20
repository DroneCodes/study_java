package leetcodeQuestions;

/**
 * This class provides a method to determine the day of the week for a given date.
 */
public class DayOfTheWeek {

    /**
     * This method returns the day of the week for a given date.
     * The date is represented by three integers: day, month, and year.
     * The method uses Zeller's Congruence algorithm to calculate the day of the week.
     * Zeller's Congruence is an algorithm devised by Christian Zeller to calculate the day of the week for any date. It can be used to determine the day of the week for any date in the past, present or future, for any dates within the valid range of the Gregorian calendar (from 1583 onwards).
     *
     * Zeller's Congruence algorithm takes into account the following factors to calculate the day of the week:
     *
     * 1. The day of the month (1-31).
     * 2. The month of the year (1-12). However, in this algorithm, January and February are counted as months 13 and 14 of the previous year. That's why there's a check in the code `if (month < 3) year = year - 1;` and why the `months` array starts with 0 (for January) and 3 (for February).
     * 3. The year. It's divided into the century part and the year part within the century. For example, for the year 2023, the century part is 20 and the year part is 23.
     * 4. Leap years are also taken into account. This is done by the terms `year / 4 - year / 100 + year / 400` in the formula, which adjust the result for leap years.
     *
     * The algorithm combines all these factors to calculate a number from 0 (for Saturday) to 6 (for Friday), which represents the day of the week.
     *
     * @param day The day of the month (1-31).
     * @param month The month of the year (1-12).
     * @param year The year.
     * @return A string representing the day of the week.
     */
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] months = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        if (month < 3) {
            year = year - 1;
        }
        int dayOfWeek = (year + year / 4 - year / 100 + year / 400 + months[month - 1] + day) % 7;
        return days[dayOfWeek];
    }

    /**
     * The main method that tests the dayOfTheWeek method with a sample date.
     *
     * @param args The command line arguments. Not used in this method.
     */
    public static void main(String[] args) {
        DayOfTheWeek day = new DayOfTheWeek();
        System.out.println(day.dayOfTheWeek(31, 8, 2019));
    }
}