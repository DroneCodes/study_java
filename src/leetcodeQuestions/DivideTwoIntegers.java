package leetcodeQuestions;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if(dividend < 0){
            sign *= -1;
        }
        if(divisor < 0){
            sign *= -1;
        }
        int quotient = 0;
        int temp = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        for(int i = 31; i >= 0; i--) {
            if(temp + (divisor << i) <= dividend){
                temp += divisor << i;
                quotient |=1 << i;
            }
        }
        return sign * quotient;
    }
}
