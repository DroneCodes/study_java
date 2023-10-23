package leetcodeQuestions.ThePowerOfFour;

public class ThePowerofFour {

        public static boolean isPowerOfFour(int num) {
            if(num == 0)
                return false;
            while(num % 4 ==0){
                num /= 4;
            }
            return num == 1;
        }

        public static void main(String[] args) {
            System.out.println(isPowerOfFour(16));
        }


    public boolean PowerOfFour(int n) {
        // Check if n is a positive power of 2 (i.e., it's a power of two)
        if (n <= 0 || (n & (n - 1)) != 0) {
            return false;
        }

        // Check if the number of trailing zeros is even
        int count = 0;
        while (n > 1) {
            n >>= 1;
            count++;
        }

        return count % 2 == 0;
    }
}


