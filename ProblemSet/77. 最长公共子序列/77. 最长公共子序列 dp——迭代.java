public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        int m = A.length();
        int n = B.length();
        char[] str1 = A.toCharArray();
        char[] str2 = B.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = (str1[i - 1] == str2[j - 1]) ? (dp[i - 1][j - 1] + 1) : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}