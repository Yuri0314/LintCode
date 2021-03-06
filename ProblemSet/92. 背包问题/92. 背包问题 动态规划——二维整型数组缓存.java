public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        int[][] dp = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; ++i) {
            for (int j = 1; j <= m; ++j) {
                int cur = A[i - 1];
                dp[i][j] = Math.max(dp[i - 1][j], j >= cur ? dp[i - 1][j - cur] + cur : 0);
            }
        }
        return dp[A.length][m];
    }
}