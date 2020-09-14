import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    private final int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private final int[] factorial = {1, 1, 2, 6, 24, 120};
    private final String target = "123450";
    /**
     * @param board: the given board
     * @return:  the least number of moves required so that the state of the board is solved
     */
    public int slidingPuzzle(int[][] board) {
        int rowNum = board.length, colNum = board[0].length;
        Queue<State> heap = new PriorityQueue<State>((a, b) -> (a.steps + a.heuristic) - (b.steps + b.heuristic));
        boolean[] seen = new boolean[720];   // 用来判断当前摆放状态是否已经走过
        State start = new State(Arrays.deepToString(board).replaceAll("[\\[\\]\\,\\s]", ""), 0);    // 将整个棋盘的当前摆放状态转换为一个字符串来存储表示
        heap.add(start);
        while (!heap.isEmpty()) {
            State cur = heap.remove();
            int cantorNum = cantor(cur.boardStr);
            if (cur.boardStr.equals(target)) return cur.steps;
            if (seen[cantorNum]) continue;
            int pos = cur.boardStr.indexOf("0");
            int x = pos / colNum, y = pos % colNum;
            for (int[] move: moves) {
                int newX = x + move[0], newY = y + move[1];
                if (newX >= 0 && newX < rowNum && newY >= 0 && newY < colNum) {
                    char[] chs = cur.boardStr.toCharArray();
                    int newPos = newX * colNum + newY;
                    chs[pos] = chs[newPos];
                    chs[newPos] = '0';
                    String nextStr = String.valueOf(chs);
                    if (!seen[cantor(nextStr)]) {
                        State next = new State(nextStr, cur.steps + 1);
                        heap.add(next);
                    }
                }
            }
            seen[cantorNum] = true;
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

    private class State {
        String boardStr;
        int steps;
        int heuristic;
        /**
         * 使用当前状态与目标状态的对应位置不同块数计算
         * @param board
         * @param steps
         */
        State(String boardStr, int steps) {
            this.boardStr = boardStr;
            this.steps = steps;
            heuristic = 0;
            char[] boardChars = boardStr.toCharArray();
            char[] targetChars = target.toCharArray();
            for (int i = 0; i < 6; ++i) {
                if (boardChars[i] == '0') continue;
                if (boardChars[i] != targetChars[i]) ++heuristic;
            }
        }
    }
}