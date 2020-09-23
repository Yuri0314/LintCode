public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        int furthestPos = 0;
        for (int i = 0; i < A.length; ++i) {
            if (i > furthestPos) return false;
            furthestPos = Math.max(furthestPos, i + A[i]);
        }
        return true;
    }
}