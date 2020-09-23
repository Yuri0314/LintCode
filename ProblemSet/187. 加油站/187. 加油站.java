public class Solution {
    /**
     * @param gas: An array of integers
     * @param cost: An array of integers
     * @return: An integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int cur = 0;
        int start = 0;
        for (int i = 0; i < gas.length; ++i) {
            int tmp = gas[i] - cost[i];
            total += tmp;
            cur += tmp;
            if (cur < 0) {
                cur = 0;
                start = i + 1;
            }
        }
        return total < 0 ? -1 : start;
    }
}