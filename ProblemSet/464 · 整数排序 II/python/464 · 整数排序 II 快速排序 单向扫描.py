import random

class Solution:
    """
    @param A: an integer array
    @return: nothing
    """
    def sortIntegers2(self, A):
        self.n = len(A)
        self.quickSort(A, 0, len(A) - 1)

    def quickSort(self, nums, left, right):
        if left < right:
            pos = self.partition(nums, left, right)
            self.quickSort(nums, left, pos - 1)
            self.quickSort(nums, pos + 1, right)

    
    def partition(self, nums, left, right):
        pivot = random.randint(0, right - left) + left
        nums[left], nums[pivot] = nums[pivot], nums[left]
        i = left
        for j in range(left + 1, right + 1):
            if nums[j] < nums[left]:
                i += 1
                nums[i], nums[j] = nums[j], nums[i]
        nums[left], nums[i] = nums[i], nums[left]
        return i