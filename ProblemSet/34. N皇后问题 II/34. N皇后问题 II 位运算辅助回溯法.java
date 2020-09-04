public class Solution {
    private int n;
    private int count;
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        this.n = n;
        count = 0;
        search(0, 0, 0, 0);
        return count;
    }

    private void search(int row, int cols, int upDiagonal, int downDiagonal) {
        if (row == n) {
            ++count;
            return;
        }
        int rowBit = ((1 << n) - 1) & (~(cols | upDiagonal | downDiagonal));
        while (rowBit != 0) {
            int curBit = rowBit & (-rowBit);    // 获取最低位的1
            rowBit ^= curBit;   // 将最低位的1置为0
            search(row + 1, cols | curBit, (upDiagonal | curBit) >> 1, (downDiagonal | curBit) << 1);
        }
    }
}