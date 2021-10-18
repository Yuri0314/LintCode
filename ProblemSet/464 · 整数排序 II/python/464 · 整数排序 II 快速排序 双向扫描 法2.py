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
        pivotIdx = random.randint(0, right - left) + left
        nums[left], nums[pivotIdx] = nums[pivotIdx], nums[left]
        low, high, pivot = left, right, nums[left]
        while low < high:
            while low < high and nums[high] >= pivot:
                high -= 1
            nums[low] = nums[high]
            while low < high and nums[low] <= pivot:
                low += 1
            nums[high] = nums[low]
        nums[low] = pivot
        return low