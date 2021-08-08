class Solution:
    """
    @param A: an integer array
    @return: nothing
    """
    def sortIntegers2(self, A):
        self.n = len(A)
        self.mergeSort(A)

    def mergeSort(self, nums):
        tmp = [None] * (self.n)
        subLen = 1
        while subLen < self.n:
            self.mergePass(nums, tmp, subLen)
            subLen <<= 1
            self.mergePass(tmp, nums, subLen)
            subLen <<= 1

    def mergePass(self, nums, tmp, subLen):
        pos = 0
        while pos <= self.n - 2 * subLen:
            self.merge(nums, tmp, pos, pos + subLen - 1, pos + subLen, pos + 2 * subLen - 1)
            pos += 2 * subLen
        if pos + subLen < self.n:
            self.merge(nums, tmp, pos, pos + subLen - 1, pos + subLen, self.n - 1)
        else:
            tmp[pos : self.n] = nums[pos : self.n]

    def merge(self, nums, tmp, lStart, lEnd, rStart, rEnd):
        i, j, pos = lStart, rStart, lStart
        while i <= lEnd and j <= rEnd:
            if nums[i] <= nums[j]:
                tmp[pos] = nums[i]
                i += 1
            else:
                tmp[pos] = nums[j]
                j += 1
            pos += 1
        tmp[pos : rEnd + 1] = nums[i : lEnd + 1] if i <= lEnd else nums[j : rEnd + 1]