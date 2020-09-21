public class Solution {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int rowNum = board.length;
        int colNum = board[0].length;
        
        UnionFind uf = new UnionFind(rowNum * colNum + 1);
        int dummyNode = rowNum * colNum;

        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == rowNum - 1 || j == 0 || j == colNum - 1)
                        uf.union(i * colNum + j, dummyNode);
                    else {
                        if (board[i - 1][j] == 'O') uf.union(i * colNum + j, (i - 1) * colNum + j);
                        if (board[i][j + 1] == 'O') uf.union(i * colNum + j, i * colNum + j + 1);
                        if (board[i + 1][j] == 'O') uf.union(i * colNum + j, (i + 1) * colNum + j);
                        if (board[i][j - 1] == 'O') uf.union(i * colNum + j, i * colNum + j - 1);
                    }
                }
            }
        }

        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                if (board[i][j] == 'O' && !uf.isConnected(i * colNum + j, dummyNode))
                    board[i][j] = 'X';
            }
        }
    }

    private class UnionFind {
        int[] parent;

        UnionFind(int N) {
            parent = new int[N];
            for (int i = 0; i < N; ++i) 
                parent[i] = -1;
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
            }
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}