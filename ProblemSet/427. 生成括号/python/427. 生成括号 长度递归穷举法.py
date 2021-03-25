from functools import lru_cache

class Solution:
    """
    @param n: n pairs
    @return: All combinations of well-formed parentheses
    """
    def generateParenthesis(self, n):
        @lru_cache(n + 1)
        def generate(n):
            if n == 0:
                return ['']
            ans = []
            for i in range(n):
                for a in generate(i):
                    for b in generate(n - i - 1):
                        ans.append('({}){}'.format(a, b))
            return ans
        
        return generate(n)
