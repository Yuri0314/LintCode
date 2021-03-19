class Solution:
    """
    @param n: An integer
    @return: An integer
    """
    def climbStairs(self, n):
        if n == 0:
            return 0
        gloden_ratio = (1 + 5 ** 0.5) / 2
        return round(gloden_ratio ** (n + 1) / (5 ** 0.5))
