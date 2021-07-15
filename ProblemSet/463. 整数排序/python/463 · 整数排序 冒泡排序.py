class Solution:
    """
    @param A: an integer array
    @return: nothing
    """
    def sortIntegers(self, A):
        for p in range(len(A) - 1, 0, -1):
            exchange = False
            for i in range(p):
                if A[i] > A[i + 1]:
                    A[i], A[i + 1] = A[i + 1], A[i]
                    exchange = True
            if not exchange:
                break