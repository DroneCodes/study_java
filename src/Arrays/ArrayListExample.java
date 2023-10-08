package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {

    public static void main(String[] args) {
        /*
            ArrayList

            - An ArrayList is a resizable array. Unlike arrays, ArrayLists are part of the Java Collections Framework.

            Syntax:

            ArrayList<DataType> variableName = new ArrayList<DataType>(initialCapacity);

            // How to add elements to an ArrayList

            variableName.add(element);

            // How to update an element in an ArrayList
            variableName.set(index, element);

            // How to check which element the ArrayList contains
            variableName.contains(element);

            // How to remove an element from an ArrayList
            variableName.remove(element);
         */

        // Create an ArrayList object

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<Integer>(5);

        // Add elements to the ArrayList

        for (int i = 0; i < 5; i++) {
            arrayList.add(scanner.nextInt());
        }

        // get item at any index in the arraylist

        for (int i = 0; i < 5; i++) {
            System.out.println(arrayList.get(i));
        }

        System.out.println(arrayList);
    }
}
