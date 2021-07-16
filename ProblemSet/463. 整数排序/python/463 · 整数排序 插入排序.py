class Solution:
    """
    @param A: an integer array
    @return: nothing
    """
    def sortIntegers(self, A):
        for p in range(1, len(A)):
            tmp = A[p]
            i = p
            while i > 0 and A[i - 1] > tmp:
                A[i] = A[i - 1]
                i -= 1
            A[i] = tmp