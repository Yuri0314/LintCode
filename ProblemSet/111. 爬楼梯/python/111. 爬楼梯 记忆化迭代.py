class Solution:
    """
    @param n: An integer
    @return: An integer
    """
    def climbStairs(self, n):
        if n <= 2:
            return n
        pre1, pre2 = 1, 2
        for _ in range(3, n + 1):
            pre1, pre2 = pre2, pre1 + pre2
        return pre2
