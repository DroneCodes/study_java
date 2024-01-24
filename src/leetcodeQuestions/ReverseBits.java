package leetcodeQuestions;
/*
The reverseBits method is designed to reverse the binary representation of an integer n.
Here's a step-by-step explanation:

- An integer res is initialized to 0. This will hold the result of the reversed bits.
- A for loop is used to iterate 32 times, which is the number of bits in an integer in Java.
- In each iteration, res is left-shifted by 1 bit. This is equivalent to multiplying res by 2 and also makes room for the next bit.
- The bitwise AND operation (n & 1) is used to get the least significant bit of n. This bit is then bitwise OR'd with res, effectively adding it to the least significant position of res.
- n is then right-shifted by 1 bit. This is equivalent to dividing n by 2 and also discards the least significant bit of n.
- After the loop, res will hold the integer value of the reversed bits of n.
- Finally, the method returns res.
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res = res | (n & 1);
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
}
