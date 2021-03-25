import java.util.List;

public class Solution {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        int minSum = nums.get(0), sum = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            sum = Math.min(nums.get(i), nums.get(i) + sum);
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }
}