public class Solution {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        long ans = 1, tmp = a;
        while (n > 0) {
            if ((n & 1) == 1) ans = (ans * tmp) % b;
            tmp = (tmp * tmp) % b;
            n >>= 1;
        }
        return (int)(ans % b);
    }
}