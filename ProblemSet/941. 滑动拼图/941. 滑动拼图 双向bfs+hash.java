import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    private final int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    /**
     * @param board: the given board
     * @return:  the least number of moves required so that the state of the board is solved
     */
    public int slidingPuzzle(int[][] board) {
        int rowNum = board.length, colNum = board[0].length;
        String start = Arrays.deepToString(board).replaceAll("[\\[\\]\\,\\s]", ""); // 将整个棋盘的当前摆放状态转换为一个字符串来存储表示
        if (start.equals("123450")) return 0;
        Queue<String> queue1 = new LinkedList<String>();    // 从起点开始广搜的队列
        Queue<String> queue2 = new LinkedList<String>();    // 从终点开始广搜的队列
        Map<String, Boolean> seen = new HashMap<String, Boolean>();   // 用来判断当前摆放状态是否已经走过
        queue1.add(start); queue2.add("123450");
        seen.put(start, true); seen.put("123450", false);
        int steps = 0;
        boolean curQueue = true;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            Queue<String> queue = curQueue ? queue1 : queue2;
            ++steps;
            for (int sz = queue.size(); sz > 0; --sz) {
                String cur = queue.remove();
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
                        if (!seen.containsKey(next)) {
                            queue.add(next);
                            seen.put(next, curQueue);
                        }
                        else if (seen.get(cur) != seen.get(next))
                            return steps;
                    }
                }
            }
            curQueue = !curQueue;
        }
        return -1;
    }
}