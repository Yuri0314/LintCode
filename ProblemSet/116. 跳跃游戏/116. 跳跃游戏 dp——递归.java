public class Solution {
    private int[] A;
    private boolean[] memo; // true表示访问过，false表示未访问过
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        this.A = A;
        memo = new boolean[A.length];
        return search(0);
    }

    private boolean search(int pos) { 
        if (pos == A.length  - 1) return true;
        if (memo[pos]) return false;    // 若当前位置访问过，说明该位置无法到达
        int furthestPos = Math.min(pos + A[pos], A.length - 1);
        for (int nextPos = furthestPos; nextPos > pos && !memo[nextPos]; --nextPos) {
            if (search(nextPos))
                return true;
        }
        memo[pos] = true;
        return false;
    }
}