class Solution:
    """
    @param A: an integer array
    @return: nothing
    """
    def sortIntegers2(self, A):
        self.tmp = [None] * len(A)
        self.mergeSort(A, 0, len(A) - 1)

    def mergeSort(self, nums, left, right):
        if left < right:
            mid = left + ((right - left) >> 1)
            self.mergeSort(nums, left, mid)
            self.mergeSort(nums, mid + 1, right)
            self.merge(nums, left, mid, mid + 1, right)

    def merge(self, nums, lStart, lEnd, rStart, rEnd):
        i, j, pos = lStart, rStart, lStart
        while i <= lEnd and j <= rEnd:
            if nums[i] <= nums[j]:
                self.tmp[pos] = nums[i]
                i += 1
            else:
                self.tmp[pos] = nums[j]
                j += 1
            pos += 1
        self.tmp[pos : rEnd + 1] = nums[i : lEnd + 1] if i <= lEnd else nums[j : rEnd + 1]
        nums[lStart : rEnd + 1] = self.tmp[lStart : rEnd + 1]