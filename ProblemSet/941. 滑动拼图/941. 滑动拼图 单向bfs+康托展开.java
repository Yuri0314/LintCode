import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private final int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private final int[] factorial = {1, 1, 2, 6, 24, 120};
    /**
     * @param board: the given board
     * @return:  the least number of moves required so that the state of the board is solved
     */
    public int slidingPuzzle(int[][] board) {
        int rowNum = board.length, colNum = board[0].length;
        String start = Arrays.deepToString(board).replaceAll("[\\[\\]\\,\\s]", ""); // 将整个棋盘的当前摆放状态转换为一个字符串来存储表示
        Queue<String> queue = new LinkedList<String>();
        boolean[] seen = new boolean[720];   // 用来判断当前摆放状态是否已经走过
        queue.add(start);
        seen[cantor(start)] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            for (int sz = queue.size(); sz > 0; --sz) {
                String cur = queue.remove();
                if (cur.equals("123450")) return steps;
                int pos = cur.indexOf("0");
                int x = pos / colNum, y = pos % colNum;
                for (int[] move: moves) {
                    int newX = x + move[0], newY = y + move[1];
                    if (newX >= 0 && newX < rowNum && newY >= 0 && newY < colNum) {
                        char[] chs = cur.toCharArray();
                        int newPos = newX * colNum + newY;
                        chs[pos] = chs[newPos];
                        chs[newPos] = '0';
                        String next = String.valueOf(chs);
                        int cantorNum = cantor(next);
                        if (!seen[cantorNum]) {
                            queue.add(next);
                            seen[cantorNum] = true;
                        }
                    }
                }
            }
            ++steps;
        }
        return -1;
    }

    /**
     * 使用康托映射计算数字排列对应的数
     * @return
     */
    private int cantor(String s) {
        char[] chs = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < 6; ++i) {
            int cnt = 0;
            for (int j = i + 1; j < 6; ++j)
                if (chs[i] > chs[j]) ++cnt;
            ans += cnt * factorial[5 - i];
        }
        return ans;
    }
}