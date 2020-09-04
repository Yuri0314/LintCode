public class Solution {
    private boolean[] cols;
    private boolean[] upDiagonal;
    private boolean[] downDiagonal;
    private int n;
    private int count;
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        cols = new boolean[n];
        upDiagonal = new boolean[2 * n - 1];
        downDiagonal = new boolean[2 * n];
        this.n = n;
        count = 0;
        search(0);
        return count;
    }

    private void search(int row) {
        if (row == n) {
            ++count;
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (!cols[i] && !upDiagonal[row + i] && !downDiagonal[row - i + n]) {
                cols[i] = true;
                upDiagonal[row + i] = true;
                downDiagonal[row - i + n] = true;
                search(row + 1);
                cols[i] = false;
                upDiagonal[row + i] = false;
                downDiagonal[row - i + n] = false;
            }
        }
    }
}