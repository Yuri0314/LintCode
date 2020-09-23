public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        boolean[] dp = new boolean[A.length];
        dp[A.length - 1] = true;
        for (int i = A.length - 2; i >= 0; --i) {
            int furthestPos = Math.min(i + A[i], A.length - 1);
            for (int j = furthestPos; j > i; --j) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}