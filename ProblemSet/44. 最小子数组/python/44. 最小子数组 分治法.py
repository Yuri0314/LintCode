class Status:
    def __init__(self, lSum, rSum, mSum, tSum):
        self.lSum = lSum
        self.rSum = rSum
        self.mSum = mSum
        self.tSum = tSum

class Solution:
    """
    @param: nums: a list of integers
    @return: A integer indicate the sum of minimum subarray
    """
    def minSubArray(self, nums):
        self.nums = nums
        return self.getSumInfo(0, len(nums) - 1).mSum
    
    def getSumInfo(self, l, r):
        if l == r:
            return Status(self.nums[l], self.nums[l], self.nums[l], self.nums[l])
        
        m = l + ((r - l) >> 1)
        lStatus = self.getSumInfo(l, m)
        rStatus = self.getSumInfo(m + 1, r)
        lSum = min(lStatus.lSum, lStatus.tSum + rStatus.lSum)
        rSum = min(rStatus.rSum, rStatus.tSum + lStatus.rSum)
        mSum = min(lStatus.rSum + rStatus.lSum, min(lStatus.mSum, rStatus.mSum))
        tSum = lStatus.tSum + rStatus.tSum
        return Status(lSum, rSum, mSum, tSum)