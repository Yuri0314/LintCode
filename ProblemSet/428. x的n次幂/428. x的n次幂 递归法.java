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
        if (N == 0) return 1.0;
        double tmp = fastPow(x, N / 2);
        return N % 2 == 0 ? tmp * tmp : tmp * tmp * x;
    }
}