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
        int pivot = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, pivot);
        int i = left;
        for (int j = left + 1; j <= right; ++j) {
            if (nums[j] < nums[left]) 
                swap(nums, ++i, j);
        }
        swap(nums, left, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}