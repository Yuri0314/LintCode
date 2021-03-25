class Solution:
    """
    @param: nums: a list of integers
    @return: A integer indicate the sum of minimum subarray
    """
    def minSubArray(self, nums):
        minSum, cur = nums[0], nums[0]
        for i in range(1, len(nums)):
            cur = min(nums[i], nums[i] + cur)
            minSum = min(minSum, cur)
        return minSum