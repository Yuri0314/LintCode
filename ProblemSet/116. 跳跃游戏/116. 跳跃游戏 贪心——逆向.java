public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        int last = A.length- 1;
        for (int i = A.length - 2; i >= 0; --i) {
            if (i + A[i] >= last) 
                last = i;
        }
        return last == 0;
    }
}