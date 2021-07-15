class Solution:
    """
    @param A: an integer array
    @return: nothing
    """
    def sortIntegers(self, A):
        for i in range(len(A)):
            min_index = i
            for j in range(i + 1, len(A)):
                if A[j] < A[min_index]:
                    min_index = j
            A[i], A[min_index] = A[min_index], A[i]