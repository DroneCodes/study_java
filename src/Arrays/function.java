package Arrays;

import java.util.Arrays;

public class function {

    // Mutability in Java (Ability to change an object after it has been created)

    public static void main(String[] args) {

            int[] numbers = {1, 2, 3, 4, 5,6 ,7, 8, 9, 10};
            System.out.println(Arrays.toString(numbers));

            change(numbers);

            System.out.println(Arrays.toString(numbers));
    }

    static void change(int[] array) {
        array[0] = 99;
    }
}
