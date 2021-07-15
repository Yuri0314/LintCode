public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        for (int p = A.length - 1; p > 0; --p) {
            boolean exchange = false;
            for (int i = 0; i < p; ++i) {
                if (A[i] > A[i + 1]) {
                    int tmp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = tmp;
                    exchange = true;
                }
            }
            if (!exchange) break;
        }
    }
}