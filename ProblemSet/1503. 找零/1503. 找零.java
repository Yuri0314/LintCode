public class Solution {
    /**
     * @param amount: The amount you should pay.
     * @return: Return the minimum number of coins for change.
     */
    public int giveChange(int amount) {
        int[] coins = {64, 16, 4, 1};
        int change = 1024 - amount;
        int num = 0;
        for (int coin : coins) {
            num += change / coin;
            change %= coin;
        }
        return num
    }
}