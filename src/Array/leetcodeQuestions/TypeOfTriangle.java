package Array.leetcodeQuestions;

/**
 * This class provides a method to determine the type of a triangle based on the lengths of its sides.
 */
public class TypeOfTriangle {

    /**
     * The main method that tests the triangleType method with a sample array of side lengths.
     *
     * @param args The command line arguments. Not used in this method.
     */
    public static void main(String[] args) {
        int[] arr = {3, 4, 5};
        System.out.println(triangleType(arr));
    }

    /**
     * This method determines the type of a triangle based on the lengths of its sides.
     * The sides are represented as an array of three integers.
     * The triangle is classified as either "Equilateral", "Isosceles", "Scalene", or "Not a Triangle".
     *
     * @param arr An array of three integers representing the lengths of the sides of a triangle.
     * @return A string representing the type of the triangle.
     */
    public static String triangleType(int[] arr) {
        if (arr[0] + arr[1] > arr[2] && arr[1] + arr[2] > arr[0] && arr[0] + arr[2] > arr[1]) {
            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                return "Equilateral";
            } else if (arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) {
                return "Isosceles";
            } else {
                return "Scalene";
            }
        } else {
            return "Not a Triangle";
        }
    }
}