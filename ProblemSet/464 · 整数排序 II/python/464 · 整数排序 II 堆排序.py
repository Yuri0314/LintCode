class Solution:
    """
    @param A: an integer array
    @return: nothing
    """
    def sortIntegers2(self, A):
<<<<<<< HEAD
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
=======
        self.nums = A
        self.n = len(A)
        self.heapSort()

    def heapSort(self):
        for i in range((self.n >> 1) - 1, -1, -1):
            self.maxHeapify(i, self.n)
        for i in range(self.n - 1, 0, -1):
            self.nums[0], self.nums[i] = self.nums[i], self.nums[0]
            self.maxHeapify(0, i)

    def maxHeapify(self, root, len):
        tmp = self.nums[root]
        while (root << 1) + 1 < len:
            child = (root << 1) + 1
            if child + 1 != len and self.nums[child] < self.nums[child + 1]:
                child += 1
            if tmp >= self.nums[child]:
                break
            else:
                self.nums[root] = self.nums[child]
            root = child
        self.nums[root] = tmp
>>>>>>> 1e7c6ca88d99bb5c35ad853537c8c7954ef14ee3
