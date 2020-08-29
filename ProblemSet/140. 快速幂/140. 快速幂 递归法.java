public class Solution {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        if (n == 0) return 1 % b;
        long tmp = fastPower(a, b, n >> 1);
        tmp = (tmp * tmp) % b;
        return (int)((n & 1) == 0 ? tmp : tmp * a % b);
    }
}