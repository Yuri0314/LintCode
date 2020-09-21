import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int rowNum;
    private int colNum;
    private boolean[][] grid;
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        rowNum = grid.length;
        colNum = grid[0].length;
        this.grid = grid;

        int islandNum = 0;

        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                if (grid[i][j]) {
                    ++islandNum;
                    bfs(i, j);
                }
            }
        }
        return islandNum;
    }

    private void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<Position>();
        grid[x][y] = false;
        queue.add(new Position(x, y));
        while (!queue.isEmpty()) {
            Position pos = queue.remove();
            int xMinus = pos.x - 1;
            int xPlus = pos.x + 1;
            int yMinus = pos.y - 1;
            int yPlus = pos.y + 1;
            if (xMinus >= 0 && grid[xMinus][pos.y]) {
                queue.add(new Position(xMinus, pos.y));
                grid[xMinus][pos.y] = false;
            }
            if (yMinus >= 0 && grid[pos.x][yMinus]) {
                queue.add(new Position(pos.x, yMinus));
                grid[pos.x][yMinus] = false;
            }
            if (xPlus < rowNum && grid[xPlus][pos.y]) {
                queue.add(new Position(xPlus, pos.y));
                grid[xPlus][pos.y] = false;
            }
            if (yPlus < colNum && grid[pos.x][yPlus]) {
                queue.add(new Position(pos.x, yPlus));
                grid[pos.x][yPlus] = false;
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