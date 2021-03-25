import java.util.List;

public class Solution {
    private List<Integer> nums;
    public class Status {
        public int lSum, rSum, mSum, tSum;

        public Status(int lSum, int rSum, int mSum, int tSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.tSum = tSum;
        }
    }
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        this.nums = nums;
        return getSumInfo(0, nums.size() - 1).mSum;
    }

    private Status getSumInfo(int l, int r) {
        if (l == r) {
            return new Status(nums.get(l), nums.get(l), nums.get(l), nums.get(l));
        }
        int m = l + ((r - l) >> 1);
        Status lStatus = getSumInfo(l, m);
        Status rStatus = getSumInfo(m + 1, r);
        int lSum = Math.min(lStatus.lSum, lStatus.tSum + rStatus.lSum);
        int rSum = Math.min(rStatus.rSum, rStatus.tSum + lStatus.rSum);
        int mSum = Math.min(lStatus.rSum + rStatus.lSum, Math.min(lStatus.mSum, rStatus.mSum));
        int tSum = lStatus.tSum + rStatus.tSum;
        return new Status(lSum, rSum, mSum, tSum);
    }
}