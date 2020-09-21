import java.util.Arrays;

public class Solution {
    private int[][] arr;
    private int[][] memo;
    private int n;
    private int m;
    /**
     * @param arr: the distance between any two cities
     * @return: the minimum distance Alice needs to walk to complete the travel plan
     */
    public int travelPlanII(int[][] arr) {
        this.arr = arr;
        n = arr.length;
        m = (1 << (n - 1));
        memo = new int[n][m];
        for (int i = 0; i < n; ++i)
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        return search(0, m - 1);
    }

    private int search(int src, int set) {
        if (set == 0) return arr[src][0];   // 如果此时集合为空，直接返回src到0结点的距离
        if (memo[src][set] != Integer.MAX_VALUE) return memo[src][set];
        for (int i = 1; i < n; ++i) {   // 遍历除了目标点0之外的每个结点
            if (((set >> (i - 1)) & 1) == 1)    // 如果集合中有该结点
                memo[src][set] = Math.min(memo[src][set], arr[src][i] + search(i, set ^ (1 << (i - 1))));
        }
        return memo[src][set];
    }
}