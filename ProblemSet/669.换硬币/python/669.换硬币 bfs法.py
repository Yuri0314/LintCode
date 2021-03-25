class Solution:
    """
    @param coins: a list of integer
    @param amount: a total amount of money amount
    @return: the fewest number of coins that you need to make up
    """
    def coinChange(self, coins, amount):
        if amount == 0:
            return 0
        
        queue = []
        seen = set()
        queue.append(0)
        steps = 0
        while len(queue):
            steps += 1
            for _ in range(len(queue)):
                cur = queue.pop(0)
                for coin in coins:
                    next = cur + coin
                    if next == amount:
                        return steps
                    if next < amount and not next in seen:
                        seen.add(next)
                        queue.append(next)

        return -1
