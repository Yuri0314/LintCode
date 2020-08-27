public class Solution {
    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        long N = n; // 防止n取绝对值之后越界
        return N >= 0 ? fastPow(x, N) : 1.0 / fastPow(x, -N);
    }

    private double fastPow(double x, long N) {
        double ans = 1.0, tmp = x;
        while (N > 0) {
            if ((N & 1) == 1) ans *= tmp;
            tmp *= tmp;
            N >>= 1;
        }
        return ans;
    }
}