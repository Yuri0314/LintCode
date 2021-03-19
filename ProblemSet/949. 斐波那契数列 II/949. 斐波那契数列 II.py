class Solution:
    """
    @param n: an integer
    @return: return an int
    """
    def lastFourDigitsOfFn(self, n):
        if n <= 1:
            return n
        ans = [[1, 0], [0, 1]]
        a = [[1, 1], [1, 0]]
        n -= 1
        while n > 0:
            if n & 1:
                ans = self.matrix_mul(ans, a)
            a = self.matrix_mul(a, a)
            n >>= 1
        return ans[0][0]
        
    def matrix_mul(self, a, b):
        tmp = [[0, 0], [0, 0]]
        for i in range(2):
            for j in range(2):
                for k in range(2):
                    tmp[i][j] = (tmp[i][j] + a[i][k] * b[k][j]) % 10000

        return tmp