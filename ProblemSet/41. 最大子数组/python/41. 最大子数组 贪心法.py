import sys

class Solution:
    """
    @param nums: A list of integers
    @return: A integer indicate the sum of max subarray
    """
    def maxSubArray(self, nums):
        maxSum, cur = -sys.maxsize - 1, 0
        for num in nums:
            cur += num
            maxSum = max(maxSum, cur)
            cur = max(cur, 0) 
        return maxSum
