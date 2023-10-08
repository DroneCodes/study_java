package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensionalArray {

    public static void main(String[] args) {

        /*
            // 2D Array
            Create an array of the type
               1 2 3
               4 5 6
               7 8 9

               2D array is defined by 2 brackets as follows;
               datatype[][] arrayName = new dataType[rows][columns];

                to input data to a 3 * 2 matrix we use the following code

                for (int row = 0; row < 3; row++) {
                    for (int column = 0; column < 2; column++) {
                        System.out.println("Enter the value for row " + row + " and column " + column);
                        array[row][column] = scanner.nextInt();
                    }
                }

                 for a matrix with a different number of columns

                 for (int row = 0; row < 3; row++) {
                    for (int column = 0; column < array[row].length; column++) {
                        System.out.println("Enter the value for row " + row + " and column " + column);
                        array[row][column] = scanner.nextInt();
                    }

                    // to print the array (option 1)
                      for (int row = 0; row < arr.length; row++) {
                         for (int column = 0; column < arr[row].length; column++) {
                            System.out.println(arr[row][column] + " ");
                       }
                       // make sure to add a new line after each row so it can be printed in a matrix form
                            System.out.println();
                     }

               // to print the array (option 2)

               for (int row = 0; row < arr.length; row++) {
                    System.out.println(Arrays.toString(arr[row]));
               }

                // to print the array (option 3)

                for (int[] ints : arr) {
                     System.out.println(Arrays.toString(ints));
                }

         */
        Scanner scanner = new Scanner(System.in);

        int[][] arr = new int[3][2];

        System.out.println(arr.length);

        // Taking input for the array
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                arr[row][column] = scanner.nextInt();
            }
        }

        // Taking the output of the array

        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
