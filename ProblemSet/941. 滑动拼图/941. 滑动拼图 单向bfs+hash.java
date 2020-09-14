import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    private final int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    /**
     * @param board: the given board
     * @return:  the least number of moves required so that the state of the board is solved
     */
    public int slidingPuzzle(int[][] board) {
        int rowNum = board.length, colNum = board[0].length;
        String start = Arrays.deepToString(board).replaceAll("[\\[\\]\\,\\s]", ""); // 将整个棋盘的当前摆放状态转换为一个字符串来存储表示
        Queue<String> queue = new LinkedList<String>();
        Set<String> seen = new HashSet<String>();   // 用来判断当前摆放状态是否已经走过
        queue.add(start);
        seen.add(start);
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
                        if (seen.add(next)) queue.add(next);
                    }
                }
            }
            ++steps;
        }
        return -1;
    }
}