package Array.leetcodeQuestions;

public class BinarySearch {

    public int binarySearch(int[] a, int k) {
        int low = 0;
        int mid;
        int high = a.length - 1;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (k < a[mid]) {
                high = mid - 1;
            } else if(k > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 2;
        System.out.println(binarySearch.binarySearch(a, k));
    }
}
