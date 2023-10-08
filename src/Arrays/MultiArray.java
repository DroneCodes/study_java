package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiArray {
    public static void main(String[] args) {
        /*
            Multi_Dimensional ArrayList

            - A multidimensional ArrayList is an ArrayList of ArrayLists.

            Syntax:

            ArrayList<ArrayList<DataType>> variableName = new ArrayList<DataType>(initialCapacity);

            initialize the multidimensional ArrayList:

            for (int i = 0; i < variableName.size(); i++) {
                variableName.add(new ArrayList<DataType>());
            }

            // How to add elements to a multidimensional ArrayList
            for (int i = 0; i < variableName.size(); i++) {
                for (int j = 0; j < variableName.size(); j++) {
                    variableName.get(i).add(in.nextInt());
                }
            }
         */
        Scanner in = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> variableName = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            variableName.add(new ArrayList<>());
        }

        // How to add elements to a multidimensional ArrayList
        for (int i = 0; i < variableName.size(); i++) {
            for (int j = 0; j < variableName.size(); j++) {
                variableName.get(i).add(in.nextInt());
            }
        }

        System.out.println(variableName);

    }
}
