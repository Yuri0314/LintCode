import java.math.BigInteger;

public class Solution {
    /**
     * @param n: an integer
     * @return:  the factorial of n
     */
    public String factorial(int n) {
        if (n == 0) return "1";
        BigInteger N = new BigInteger(String.valueOf(n));
        BigInteger oneInteger = new BigInteger("1");
        BigInteger ans = oneInteger;
        for (BigInteger i = new BigInteger("2"); i.compareTo(N) <= 0; i = i.add(oneInteger))
            ans = ans.multiply(i);
        return ans.toString();
    }
}