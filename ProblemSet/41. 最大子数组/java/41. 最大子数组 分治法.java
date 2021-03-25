public class Solution {
    private int[] nums;
    public class Status {
        public int lSum, rSum, mSum, tSum;

        public Status(int lSum, int rSum, int mSum, int tSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.tSum = tSum;
        }
    }
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        this.nums = nums;
        return getSumInfo(0, nums.length - 1).mSum;
    }

    private Status getSumInfo(int l, int r) {
        if (l == r) {
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }
        int m = l + ((r - l) >> 1);
        Status lStatus = getSumInfo(l, m);
        Status rStatus = getSumInfo(m + 1, r);
        int lSum = Math.max(lStatus.lSum, lStatus.tSum + rStatus.lSum);
        int rSum = Math.max(rStatus.rSum, rStatus.tSum + lStatus.rSum);
        int mSum = Math.max(lStatus.rSum + rStatus.lSum, Math.max(lStatus.mSum, rStatus.mSum));
        int tSum = lStatus.tSum + rStatus.tSum;
        return new Status(lSum, rSum, mSum, tSum);
    }
}