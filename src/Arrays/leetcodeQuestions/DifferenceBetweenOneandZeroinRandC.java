package Arrays.leetcodeQuestions;

public class DifferenceBetweenOneandZeroinRandC {

    public int[][] onesMinusZeros(int[][] grid) {
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        int[][] result = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int count1 = 0;
            int count0 = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1){
                    count1++;
                }
                else{
                    count0++;
                }
            }
            row[i] = count1-count0;
        }

        for (int i = 0; i < grid[0].length; i++) {
            int count1 = 0;
            int count0 = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i]==1){
                    count1++;
                }
                else{
                    count0++;
                }
            }
            col[i] = count1-count0;
        }

        for (int i = 0; i < grid.length; i++) {
            result[i][i] = row[i];
        }

        for (int i = 0; i < grid[0].length; i++) {
            result[i][i] = col[i];
        }

        return result;
    }
}
