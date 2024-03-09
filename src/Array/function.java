package Array;

import java.util.Arrays;

public class function {

    // Mutability in Java (Ability to change an object after it has been created)

    public static void main(String[] args) {

        int[] arr = new int[5];

        set(arr, 0, 10);
        set(arr, 1, 20);
        set(arr, 2, 30);
        set(arr, 3, 40);
        set(arr, 4, 50);

        System.out.println(Arrays.toString(arr));

        reverse(arr);

        System.out.println(Arrays.toString(arr));

        max(arr);

    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1]; // store the value at index1 in a temporary variable
        arr[index1] = arr[index2]; // store the value at index2 in index1
        arr[index2] = temp; // store the value at index1 in index2
    }

    static void reverse(int[] arr) {

        if (arr == null || arr.length == 0) {
            System.out.println("Array is null or empty");
            return;
        }
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

    static void replaceElement(int[] arr, int index, int value) {
        int temp = value;
        arr[index] = temp;
    }


    static void get(int[] arr, int index) {
        int temp = arr[index];
        System.out.println(temp);
    }

    static void set(int[] arr, int index, int value) {
        int temp = value;
        arr[index] = temp;
    }

    static void remove(int[] arr, int index) {
        int temp = arr[index];
        arr[index] = arr[arr.length - 1];
    }

    static int max(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is null or empty");
            return -1;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
        return max;
    }

    static int maxRange(int[] arr, int start, int end) {

        if (end > start) {
            System.out.println("Invalid range");
            return -1;
        }

        if (arr == null) {
            System.out.println("Array is null");
            return -1;
        }

        int max = arr[start];
        for (int i = start; i < end; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
        return max;
    }


}
