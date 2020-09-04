import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<String>> ans = new ArrayList<List<String>>();
    private int[] queens;   // 存储皇后位置
    private int n;
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        queens = new int[n];
        this.n = n;
        search(0, 0, 0, 0);
        return ans;
    }

    private void search(int row, int cols, int upDiagonal, int downDiagonal) {
        if (row == n) {
            List<String> solution = drawSolution();
            ans.add(solution);
            return;
        }
        int rowBit = ((1 << n) - 1) & (~(cols | upDiagonal | downDiagonal));
        while (rowBit != 0) {
            int curBit = rowBit & (-rowBit);    // 获取最低位的1
            rowBit ^= curBit;   // 将最低位的1置为0
            queens[row] = Integer.bitCount(curBit - 1); //获取对应列号
            search(row + 1, cols | curBit, (upDiagonal | curBit) >> 1, (downDiagonal | curBit) << 1);
            // 回溯结束时无需恢复queens[row]位置，因为会覆盖
        }
    }

    private List<String> drawSolution() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            solution.add(new String(row));
        }
        return solution;
    }
}