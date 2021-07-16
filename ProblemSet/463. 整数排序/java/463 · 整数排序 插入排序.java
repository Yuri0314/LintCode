public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        for (int p = 1; p < A.length; ++p) {
            int tmp = A[p];
            int i = p;
            for (; i > 0 && A[i - 1] > tmp; --i)
                A[i] = A[i - 1];
            A[i] = tmp;
        }
    }
}