import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<String>> ans = new ArrayList<List<String>>();
    private int[] queens;   // 存储皇后位置
    private boolean[] cols;
    private boolean[] upDiagonal;
    private boolean[] downDiagonal;
    private int n;
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        queens = new int[n];
        cols = new boolean[n];
        upDiagonal = new boolean[2 * n - 1];
        downDiagonal = new boolean[2 * n];
        this.n = n;
        search(0);
        return ans;
    }

    private void search(int row) {
        if (row == n) {
            List<String> solution = drawSolution();
            ans.add(solution);
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (!cols[i] && !upDiagonal[row + i] && !downDiagonal[row - i + n]) {
                queens[row] = i;
                cols[i] = true;
                upDiagonal[row + i] = true;
                downDiagonal[row - i + n] = true;
                search(row + 1);
                // 回溯结束时无需恢复queens[row]位置，因为会覆盖
                cols[i] = false;
                upDiagonal[row + i] = false;
                downDiagonal[row - i + n] = false;
            }
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