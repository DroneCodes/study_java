package leetcodeQuestions;


/**
 * This class provides a method to build a staircase with coins.
 * The staircase consists of k rows where the ith row has exactly i coins.
 * The last row of the staircase may be incomplete.
 */
public class CoinStaircase {

    /**
     * This method calculates the number of complete rows of the staircase that can be built with the given number of coins.
     * It uses a simple loop to subtract the number of coins in each row from the total number of coins until there are not enough coins to complete the next row.
     *
     * @param n The total number of coins.
     * @return The number of complete rows of the staircase.
     */
    public int arrangeCoins(int n) {
        int rows = 0;
        while (n > rows) {
            rows++;
            n -= rows;
        }
        return rows;
    }
}

