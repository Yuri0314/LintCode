import java.util.Arrays;

public class Solution {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; ++i)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }
}