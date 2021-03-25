public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(maxSum, sum);
            sum = Math.max(sum, 0);
        }
        return maxSum;
    }
}