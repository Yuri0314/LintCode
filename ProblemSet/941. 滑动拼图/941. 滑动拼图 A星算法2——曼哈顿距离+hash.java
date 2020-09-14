import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {
    private final int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private final int[][] sheet={
        {0,0},{0,1},{0,2},
        {1,0},{1,1},{1,2}
    };
    /**
     * @param board: the given board
     * @return:  the least number of moves required so that the state of the board is solved
     */
    public int slidingPuzzle(int[][] board) {
        int rowNum = board.length, colNum = board[0].length;
        Queue<State> heap = new PriorityQueue<State>((a, b) -> (a.steps + a.heuristic) - (b.steps + b.heuristic));
        Set<String> seen = new HashSet<String>();   // 用来判断当前摆放状态是否已经走过
        State start = new State(Arrays.deepToString(board).replaceAll("[\\[\\]\\,\\s]", ""), 0);    // 将整个棋盘的当前摆放状态转换为一个字符串来存储表示
        heap.add(start);
        while (!heap.isEmpty()) {
            State cur = heap.remove();
            if (cur.boardStr.equals("123450")) return cur.steps;
            if (seen.contains(cur.boardStr)) continue;
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
                    if (!seen.contains(nextStr)) {
                        State next = new State(nextStr, cur.steps + 1);
                        heap.add(next);
                    }
                }
            }
            seen.add(cur.boardStr);
        }
        return -1;
    }

    private class State {
        String boardStr;
        int steps;
        int heuristic;
        /**
         * 使用曼哈顿距离计算
         * @param board
         * @param steps
         */
        State(String boardStr, int steps) {
            this.boardStr = boardStr;
            this.steps = steps;
            heuristic = 0;
            char[] boardChars = boardStr.toCharArray();
            for (int i = 0; i < 6; ++i) {
                if (boardChars[i] == '0') continue;
                int val = boardChars[i] - '0' - 1;
                heuristic += Math.abs(sheet[i][0] - sheet[val][0]) + Math.abs(sheet[i][1] - sheet[val][1]);
            }
        }
    }
}