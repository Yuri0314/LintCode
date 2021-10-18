public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        heapSort(A);
    }
<<<<<<< HEAD
    
=======

>>>>>>> 1e7c6ca88d99bb5c35ad853537c8c7954ef14ee3
    private void heapSort(int[] nums) {
        for (int i = (nums.length >> 1) - 1; i >= 0; --i)
            maxHeapify(nums, i, nums.length);
        for (int i = nums.length - 1; i > 0; --i) {
            swap(nums, 0, i);
            maxHeapify(nums, 0, i);
        }
    }

    private void maxHeapify(int[] nums, int root, int len) {
        int tmp = nums[root];
        while ((root << 1) + 1 < len) {
            int child = (root << 1) + 1;
            if (child + 1 != len && nums[child] < nums[child + 1]) ++child;
            if (tmp >= nums[child]) break;
            else nums[root] = nums[child];
            root = child;
        }
        nums[root] = tmp;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}