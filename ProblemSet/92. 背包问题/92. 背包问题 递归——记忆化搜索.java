import java.util.Arrays;

public class Solution {
    private int[] A;
    private int[][] dp;
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        this.A = A;
        this.dp = new int[A.length][m + 1];
        for (int i = 0; i < A.length; ++i)
            Arrays.fill(dp[i], -1);
        return search(A.length - 1, m);
    }

    private int search(int i, int m) {
        if (i < 0) return 0;
        if (dp[i][m] == -1)
            dp[i][m] = Math.max(search(i - 1, m), m >= A[i] ? search(i - 1, m - A[i]) + A[i] : 0);
        return dp[i][m];
    }
}