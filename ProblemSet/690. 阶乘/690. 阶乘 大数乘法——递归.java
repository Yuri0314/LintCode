import java.math.BigInteger;

public class Solution {
    private final BigInteger oneInteger = new BigInteger("1");
    /**
     * @param n: an integer
     * @return:  the factorial of n
     */
    public String factorial(int n) {
        if (n == 0) return "1";
        return bigIntegerFactorial(new BigInteger(String.valueOf(n))).toString();
    }

    private BigInteger bigIntegerFactorial(BigInteger n) {
        if (n.equals(oneInteger)) return oneInteger;
        return n.multiply(bigIntegerFactorial(n.subtract(oneInteger)));
    }
}