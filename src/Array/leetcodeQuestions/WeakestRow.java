package Array.leetcodeQuestions;

public class WeakestRow {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j]==1){
                    count++;
                }
            }
            row[i]=count;
        }

        for (int i = 0; i < mat[0].length; i++) {
            int count = 0;
            for (int j = 0; j < mat.length; j++) {
                if(mat[j][i]==1){
                    count++;
                }
            }
            col[i]=count;
        }

        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = 0; j < mat.length; j++) {
                if(row[j]<min){
                    min=row[j];
                    index=j;
                }
            }
            ans[i]=index;
            row[index]=Integer.MAX_VALUE;
        }
        return ans;
    }
}
