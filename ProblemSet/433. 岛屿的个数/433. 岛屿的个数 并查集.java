public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int rowNum = grid.length;
        int colNum = grid[0].length;

        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                if (grid[i][j]) {
                    grid[i][j] = false;
                    int newX = i + 1;
                    int newY = j + 1;
                    if (newX < rowNum && grid[newX][j]) uf.union(i * colNum + j, newX * colNum + j);
                    if (newY < colNum && grid[i][newY]) uf.union(i * colNum + j, i * colNum + newY);
                }
            }
        }
        return uf.count;
    }

    private class UnionFind {
        int count;
        int[] parent;

        UnionFind(boolean[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j]) {
                        parent[i * n + j] = -1;
                        ++count;
                    }
                }
            }
        }

        int find(int x) {
            if (parent[x] < 0) return x;
            else {
                parent[x] = find(parent[x]);
                return parent[x];
            }
        }

        void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (parent[rootx] <= parent[rooty]) {
                    parent[rootx] += parent[rooty];
                    parent[rooty] = rootx;
                }
                else if (parent[rootx] > parent[rooty]) {
                    parent[rooty] += parent[rootx];
                    parent[rootx] = rooty;
                }
                --count;
            }
        }
    }
}