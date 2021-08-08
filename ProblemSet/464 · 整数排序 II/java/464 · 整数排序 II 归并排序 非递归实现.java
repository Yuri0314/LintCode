public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        mergeSort(A);
    }
    
    private void mergeSort(int[] nums) {
        int[] tmp = new int[nums.length];
        int subLen = 1;
        while (subLen < nums.length) {
            mergePass(nums, tmp, subLen);
            subLen <<= 1;
            mergePass(tmp, nums, subLen);
            subLen <<= 1;
        }
    }

    private void mergePass(int[] nums, int[] tmp, int subLen) {
        int pos = 0;
        while (pos <= nums.length - 2 * subLen) {
            merge(nums, tmp, pos, pos + subLen - 1, pos + subLen, pos + 2 * subLen - 1);
            pos += 2 * subLen;
        }
        if (pos + subLen < nums.length) merge(nums, tmp, pos, pos + subLen - 1, pos + subLen, nums.length - 1);
        else {
            for (int i = pos; i < nums.length; ++i)
                tmp[i] = nums[i];
        }
    }

    private void merge(int[] nums, int[] tmp, int lStart, int lEnd, int rStart, int rEnd) {
        int i = lStart, j = rStart, pos = lStart;
        while (i <= lEnd && j <= rEnd) tmp[pos++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        while (i <= lEnd) tmp[pos++] = nums[i++];
        while (j <= rEnd) tmp[pos++] = nums[j++];
    }
}