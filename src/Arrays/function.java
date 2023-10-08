package Arrays;

import java.util.Arrays;

public class function {

    // Mutability in Java (Ability to change an object after it has been created)

    public static void main(String[] args) {

            int[] numbers = {1, 2, 3, 4, 5,6 ,7, 8, 9, 10};
            System.out.println(Arrays.toString(numbers));

            change(numbers);

            System.out.println(Arrays.toString(numbers));

            reverse(numbers);

        System.out.println(Arrays.toString(numbers));

        remove(numbers, 2);

        System.out.println(Arrays.toString(numbers));

        replaceElement(numbers, 2, 99);
    }

    static void change(int[] array) {
        array[0] = 99;
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1]; // store the value at index1 in a temporary variable
        arr[index1] = arr[index2]; // store the value at index2 in index1
        arr[index2] = temp; // store the value at index1 in index2
    }

    static void reverse(int[] arr) {
        // Initialize two pointers, 'start' and 'end', to the beginning and end of the array.
        int start = 0;
        int end = arr.length - 1;

        // Use a while loop to swap elements until 'start' becomes greater than or equal to 'end'.
        while (start < end) {
            // Call the 'swap' method to exchange the elements at 'start' and 'end'.
            swap(arr, start, end);

            // Increment 'start' to move towards the end of the array.
            start++;

            // Decrement 'end' to move towards the beginning of the array.
            end--;
        }
    }

    static void replaceElement(int[] arr, int index1, int value) {
        arr[index1] = value;
    }

    static  void remove(int[] arr, int index) {
        for (int i = index; i < arr.length - 1; i++) {
            // Shift the elements to the left from the index to the end of the array.
            arr[i] = arr[i + 1];
        }
    }
}
