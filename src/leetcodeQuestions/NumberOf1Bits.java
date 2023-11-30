package leetcodeQuestions;

public class NumberOf1Bits {

        public static int hammingWeight(int n) {
            int count = 0;
            while (n!=0){
                count++;
                n = n & (n-1);
            }
            return count;
        }

        public static void main(String[] args) {
            System.out.println(hammingWeight(00000000000000000000000000001011));
        }
}
