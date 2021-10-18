class Solution:
    """
    @param A: an integer array
    @return: nothing
    """
    def sortIntegers2(self, A):
        self.n = len(A)
        self.heapSort(A)

    def heapSort(self, nums):
        for i in range((self.n >> 1) - 1, -1, -1):
            self.maxHeapify(nums, i, self.n)
        for i in range(self.n - 1, 0, -1):
            nums[0], nums[i] = nums[i], nums[0]
            self.maxHeapify(nums, 0, i)

    def maxHeapify(self, nums, root, len):
        tmp = nums[root]
        while (root << 1) + 1 < len:
            child = (root << 1) + 1
            if child + 1 != len and nums[child] < nums[child + 1]:
                child += 1
            if tmp >= nums[child]:
                break
            else:
                nums[root] = nums[child]
            root = child
        nums[root] = tmp
