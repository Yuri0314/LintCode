public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        for (int i = (A.length - 1) / 2; i >= 0; --i)
            siftdown(A, i);
    }

    private void siftdown(int[] A, int p) {
        int x = A[p];
        while (p * 2 + 1 < A.length) {
            int minSon = p * 2 + 1;
            if (minSon + 1 < A.length && A[minSon] > A[minSon + 1])
                ++minSon;
            if (A[minSon] >= x) break;
            A[p] = A[minSon];
            p = minSon;
        }
        A[p] = x;
    }
}