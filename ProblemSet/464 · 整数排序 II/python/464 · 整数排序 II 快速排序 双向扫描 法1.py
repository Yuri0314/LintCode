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
        low, high, pivot = left + 1, right, nums[left]
        while True:
            while low <= high and nums[low] < pivot:
                low += 1
            while low <= high and nums[high] > pivot:
                high -= 1
            if low < high:
                nums[low], nums[high] = nums[high], nums[low]
                low += 1
                high -= 1
            else:
                break
        nums[left], nums[high] = nums[high], nums[left]
        return high