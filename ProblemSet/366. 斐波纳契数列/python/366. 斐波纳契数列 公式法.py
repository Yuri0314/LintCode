class Solution:
    """
    @param n: an integer
    @return: an ineger f(n)
    """
    def fibonacci(self, n):
        gloden_ratio = (1 + 5 ** 0.5) / 2
        return round(gloden_ratio ** (n - 1)  / (5 ** 0.5))
