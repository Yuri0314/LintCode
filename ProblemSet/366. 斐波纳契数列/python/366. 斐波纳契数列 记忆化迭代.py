class Solution:
    """
    @param n: an integer
    @return: an ineger f(n)
    """
    def fibonacci(self, n):
        if n <= 2:
            return n - 1
        pre1, pre2 = 0, 1
        for _ in range(3, n + 1):
            pre1, pre2 = pre2, pre1 + pre2
        return pre2
