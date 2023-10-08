package Arrays;

public class NoFixedColumn {

    public static void main(String[] args) {
        /*
            2D Array without fixed columns
         */

        int[][] arr = {
            {1, 2, 3, 4},
            {5, 6},
            {7, 8, 9}
        };

        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) { // arr[row].length is used to get the number of columns in each row
                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }
    }
}
