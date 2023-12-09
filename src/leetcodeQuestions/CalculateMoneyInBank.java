package leetcodeQuestions;

public class CalculateMoneyInBank {

    public int totalMoney(int n) {
        int total = 0;
        int week = 0;
        int day = 0;
        // Loop until n becomes 0
        while (n > 0) {
            // If it's the 7th day of the week, reset the day and increase the week
            if (day == 7) {
                day = 0;
                week++;
            }
            // Add the current week and day to the total
            total += week + day + 1;
            // Increase the day and decrease n
            day++;
            n--;
        }
        // Return the total money
        return total;
    }
}