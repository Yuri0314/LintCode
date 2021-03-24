class Solution:
    """
    @param amount: The amount you should pay.
    @return: Return the minimum number of coins for change.
    """
    def giveChange(self, amount):
        coins = [64, 16, 4, 1]
        change = 1024 - amount
        num = 0
        for coin in coins:
            num += change // coin
            change %= coin
        return num
