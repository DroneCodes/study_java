package leetcodeQuestions;

public class PowerXN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            return myPow(1 / x, -(n + 1)) / x;
        }
        double result = myPow(x * x, n / 2);
        if (n % 2 == 1) {
            result *= x;
        }
        return result;
    }
}
