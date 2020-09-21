public class Solution {
    /**
     * @param arr: the distance between any two cities
     * @return: the minimum distance Alice needs to walk to complete the travel plan
     */
    public int travelPlanII(int[][] arr) {
        int n = arr.length;
        int m = (1 << (n - 1));
        int[][] dp = new int[n][m];
        for (int i = 1; i < n; ++i) dp[i][0] = arr[i][0];
        for (int j = 1; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                dp[i][j] = Integer.MAX_VALUE;
                if (((j >> (i - 1)) & 1) == 1) continue;    // 如果集合包括源点则跳过
                for (int k = 1; k < n; ++k) {   // 对集合依次遍历所有结点
                    if (((j >> (k - 1)) & 1) == 1)  // 集合存在该结点
                        dp[i][j] = Math.min(dp[i][j], arr[i][k] + dp[k][j ^ (1 << (k - 1))]);
                }
            }
        }
        return dp[0][m - 1];
    }
}