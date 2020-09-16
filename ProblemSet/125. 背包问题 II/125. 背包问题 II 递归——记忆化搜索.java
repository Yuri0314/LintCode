import java.util.Arrays;

public class Solution {
    private int[] A;
    private int[] V;
    private int[][] memo;
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        this.A = A;
        this.V = V;
        memo = new int[A.length][m + 1];
        for (int i = 0; i < A.length; ++i)
            Arrays.fill(memo[i], -1);
        return search(A.length - 1, m);
    }

    private int search(int i, int m) {
        if (i < 0) return 0;
        if (memo[i][m] == -1)
            memo[i][m] = Math.max(search(i - 1, m), m >= A[i] ? search(i - 1, m - A[i]) + V[i] : 0);
        return memo[i][m];
    }
}