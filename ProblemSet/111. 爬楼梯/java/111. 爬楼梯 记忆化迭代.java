public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int pre1 = 1, pre2 = 2, cur = 3;
        for (int i = 3; i <= n; ++i) {
            cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return cur;
    }
}