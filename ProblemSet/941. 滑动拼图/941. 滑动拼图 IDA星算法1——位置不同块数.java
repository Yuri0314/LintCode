import java.util.Arrays;

public class Solution {
    private int rowNum;
    private int colNum;
    private int bound;
    private int steps;
    private final int[][] moves = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private final String target = "123450";
    /**
     * @param board: the given board
     * @return:  the least number of moves required so that the state of the board is solved
     */
    public int slidingPuzzle(int[][] board) {
        rowNum = board.length; colNum = board[0].length;
        State start = new State(Arrays.deepToString(board).replaceAll("[\\[\\]\\,\\s]", ""));    // 将整个棋盘的当前摆放状态转换为一个字符串来存储表示
        bound = start.cost; // 用当前状态的代价估计值来初始化最大界限深度
        steps = 0;
        while (!dfs(start, 0, 4) && bound < 20) ++bound;    // 限定最大搜索深度为20
        return bound < 20 ? steps : -1;
    }

    private boolean dfs(State cur, int steps, int lastDir) {
        if (cur.cost + steps > bound) return false;
        if (cur.boardStr.equals(target)) {
            this.steps = steps;
            return true;
        } 
        int pos = cur.boardStr.indexOf("0");
        int x = pos / colNum, y = pos % colNum;
        for (int i = 0; i < 4; ++i) {
            if (i + lastDir == 3) continue; // 防止走回头路
            int newX = x + moves[i][0], newY = y + moves[i][1];
            if (newX >= 0 && newX < rowNum && newY >= 0 && newY < colNum) {
                char[] chs = cur.boardStr.toCharArray();
                int newPos = newX * colNum + newY;
                chs[pos] = chs[newPos];
                chs[newPos] = '0';
                State next = new State(String.valueOf(chs));
                if (dfs(next, steps + 1, i)) return true;
            }
        }
        return false;
    } 

    private class State {
        String boardStr;
        int cost;
        /**
         * 使用当前状态与目标状态的对应位置不同块数计算
         * @param board
         * @param steps
         */
        State(String boardStr) {
            this.boardStr = boardStr;
            cost = 0;
            char[] boardChars = boardStr.toCharArray();
            char[] targetChars = target.toCharArray();
            for (int i = 0; i < 6; ++i) {
                if (boardChars[i] == '0') continue;
                if (boardChars[i] != targetChars[i]) ++cost;
            }
        }
    }
}