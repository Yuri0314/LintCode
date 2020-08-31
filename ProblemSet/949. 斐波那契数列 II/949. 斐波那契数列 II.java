public class Solution {
    /**
     * @param n: an integer
     * @return: return an int
     */
    public int lastFourDigitsOfFn(int n) {
        if (n <= 1) return n;
        int[][] ans = new int[][]{{1, 0}, {0, 1}};
        int[][] A = new int[][]{{1, 1}, {1, 0}};
        --n;
        while (n > 0) {
            if ((n & 1) == 1) ans = matrixMul(ans, A);
            A = matrixMul(A, A);
            n >>= 1;
        }
        return ans[0][0];
    }

    private int[][] matrixMul(int[][] A, int[][] B) {
        int[][] tmp = new int[][]{{0, 0}, {0, 0}};
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 2; ++k)
                    tmp[i][j] = (tmp[i][j] + A[i][k] * B[k][j]) % 10000;
            }
        }
        return tmp;
    }
}