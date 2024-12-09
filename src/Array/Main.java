package Array;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        String[] names = {"John", "Jane", "Jill", "Jack"};

        String[] newNames = new String[5];



        for (int i = 0; i < names.length; i++) {
            newNames[i] = names[i];
        }

        System.out.println(newNames[4]);

        // for loop to request the user to input each required value for the array

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < newNames.length; i++) {
            newNames[i] = scanner.next();
        }

        for (int i = 0; i < newNames.length; i++) {
            System.out.print(newNames[i] + " ");
        }

    }
}