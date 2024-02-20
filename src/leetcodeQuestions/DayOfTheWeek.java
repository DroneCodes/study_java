package leetcodeQuestions;

/**
 * This class provides a method to determine the day of the week for a given date.
 */
public class DayOfTheWeek {

    /**
     * This method returns the day of the week for a given date.
     * The date is represented by three integers: day, month, and year.
     * The method uses Zeller's Congruence algorithm to calculate the day of the week.
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