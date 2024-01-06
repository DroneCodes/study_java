package Arrays.leetcodeQuestions;


/*
To solve this problem, we can use a dynamic programming approach. We will iterate over each row and for each row, we will calculate the number of laser beams that can be formed with the previous rows. We will store this information in a 2D array dp, where dp[i][j] represents the number of laser beams that can be formed with the i-th row and the j-th column.

Here are the steps in detail:

1. Initialize a 2D array dp with size m x n, where m is the number of rows and n is the number of columns in the bank. Set all elements in dp to 0.

2. Iterate over each row from top to bottom. For each row, iterate over each column from left to right.

3. If the current cell has a security device (i.e., bank[i][j] == '1'), then iterate over all previous rows from the current row to the top. For each previous row, if the cell in the same column also has a security device (i.e., bank[k][j] == '1'), then increment dp[i][j] by dp[k][j] + 1. This is because a laser beam can be formed between the current cell and the cell in the previous row, and also all the laser beams that can be formed with the cell in the previous row can also be formed with the current cell.

4. After iterating over all rows and columns, the total number of laser beams is the sum of all elements in dp.

Here is the Java code for the problem:

```java
package Arrays.leetcodeQuestions;

public class NumberOfLaserBeams {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int n = bank[0].length();
        int[][] dp = new int[m][n];
        int totalBeams = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bank[i].charAt(j) == '1') {
                    for (int k = 0; k < i; k++) {
                        if (bank[k].charAt(j) == '1') {
                            dp[i][j] += dp[k][j] + 1;
                        }
                    }
                    totalBeams += dp[i][j];
                }
            }
        }

        return totalBeams;
    }
}
```

In this code, we first initialize the dp array and the totalBeams variable. Then, we iterate over each row and column. If the current cell has a security device, we iterate over all previous rows and if the cell in the same column also has a security device, we increment dp[i][j] by dp[k][j] + 1. Finally, we add dp[i][j] to totalBeams. After iterating over all rows and columns, we return totalBeams as the total number of laser beams.
 */
public class NumberOfLaserBeams {
    public int numberOfBeams(String[] bank) {
        int prevRowCount = 0;
        int total=0;

        for(String row : bank) {
            int curRowCount = calc(row);
            if(curRowCount==0)
                continue;

            total += curRowCount * prevRowCount;
            prevRowCount = curRowCount;
        }
        return total;
    }

    private int calc(String s) {
        int count = 0;
        for(char c : s.toCharArray())
            count += c - '0';

        return count;
    }
}
