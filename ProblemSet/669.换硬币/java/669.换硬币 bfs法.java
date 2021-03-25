import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        queue.add(0);
        int steps = 0;
        while (!queue.isEmpty()) {
            ++steps;
            for (int sz = queue.size(); sz > 0; --sz) {
                int cur = queue.remove();
                for (int coin : coins) {
                    int next = cur + coin;
                    if (next == amount) return steps;
                    if (next < amount && seen.add(next)) queue.add(next);
                }
            }
        }
        return -1;
    }
}