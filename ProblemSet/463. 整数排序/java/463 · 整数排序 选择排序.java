public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < A.length; ++j) 
                if (A[j] < A[minIndex]) 
                    minIndex = j;
            int tmp = A[i];
            A[i] = A[minIndex];
            A[minIndex] = tmp;
        }
    }
}