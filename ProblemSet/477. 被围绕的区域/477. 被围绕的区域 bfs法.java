import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int rowNum;
    private int colNum;
    private char[][] board;
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        rowNum = board.length;
        colNum = board[0].length;
        this.board = board;
        for (int i = 0; i < rowNum; ++i) {
            if (board[i][0] == 'O') bfs(i, 0);
            if (board[i][colNum - 1] == 'O') bfs(i, colNum - 1);
        }
        for (int j = 0; j < colNum; ++j) {
            if (board[0][j] == 'O') bfs(0, j);
            if (board[rowNum - 1][j] == 'O') bfs(rowNum - 1, j);
        }
        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '-') board[i][j] = 'O';
            }
        }
    }

    private void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<Position>();
        board[x][y] = '-';
        queue.add(new Position(x, y));
        while (!queue.isEmpty()) {
            Position pos = queue.remove();
            int xMinus = pos.x - 1;
            int xPlus = pos.x + 1;
            int yMinus = pos.y - 1;
            int yPlus = pos.y + 1;
            if (xMinus >= 0 && board[xMinus][pos.y] == 'O') {
                queue.add(new Position(xMinus, pos.y));
                board[xMinus][pos.y] = '-';
            }
            if (yMinus >= 0 && board[pos.x][yMinus] == 'O') {
                queue.add(new Position(pos.x, yMinus));
                board[pos.x][yMinus] = '-';
            }
            if (xPlus < rowNum && board[xPlus][pos.y] == 'O') {
                queue.add(new Position(xPlus, pos.y));
                board[xPlus][pos.y] = '-';
            }
            if (yPlus < colNum && board[pos.x][yPlus] == 'O') {
                queue.add(new Position(pos.x, yPlus));
                board[pos.x][yPlus] = '-';
            }
        }
    }

    private class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}