package leetcodeQuestions;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {

        if(n == 0){
            return false;
        }


        while(n % 2 == 0){
            n = n / 2;
        }
        if(n == 1){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
        System.out.println(isPowerOfTwo.isPowerOfTwo(15));
    }
}
