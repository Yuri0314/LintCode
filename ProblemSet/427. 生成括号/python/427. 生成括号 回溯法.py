class Solution:
    """
    @param n: n pairs
    @return: All combinations of well-formed parentheses
    """
    def generateParenthesis(self, n):
        ans = []
        def backtrace(cur, left_num, right_num):
            if len(cur) == 2 * n:
                ans.append(''.join(cur))
                return
            if left_num < n:
                cur.append('(')
                backtrace(cur, left_num + 1, right_num)
                cur.pop()
            if right_num < left_num:
                cur.append(')')
                backtrace(cur, left_num, right_num + 1)
                cur.pop()
        
        backtrace([], 0, 0)
        return ans
