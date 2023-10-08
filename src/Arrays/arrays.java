package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class arrays {

    public static void main(String[] args) {

        Scanner character = new Scanner(System.in);

        String[] names = new String[5];

        for (int i = 0; i < names.length; i++) {
            names[i] = character.next();
        }

        for (String name : names) { // for every element in the array names, print the element
            System.out.println(name + " "); // iterates through the array and prints each element
        }

        System.out.println(Arrays.toString(names));

        // An array containing strings
        String[] string = new String[4];

        for (int i = 0; i < string.length; i++) {
            string[i] = character.next();  // input elements into the array
        }

        for (int i = 0; i < string.length; i++) {
            System.out.print(string[i] + " "); // print the elements in the array
        }
    }
}
