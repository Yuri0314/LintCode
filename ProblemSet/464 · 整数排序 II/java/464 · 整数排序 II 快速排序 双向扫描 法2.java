import java.util.Random;

public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = partition(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, pivotIndex);
        int low = left, high = right, pivot = nums[left];
        while (low < high) {
            while (low < high && nums[high] >= pivot) --high;
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) ++low;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}