import java.math.BigInteger;

public class Solution {
    private final BigInteger oneInteger = new BigInteger("1");
    /**
     * @param n: an integer
     * @return:  the factorial of n
     */
    public String factorial(int n) {
        if (n == 0) return "1";
        return bigIntegerFactorial(oneInteger, new BigInteger(String.valueOf(n))).toString();
    }

    private BigInteger bigIntegerFactorial(BigInteger tmp, BigInteger cur) {
        if (cur.equals(oneInteger)) return tmp;
        return bigIntegerFactorial(tmp.multiply(cur), cur.subtract(oneInteger));
    }
}