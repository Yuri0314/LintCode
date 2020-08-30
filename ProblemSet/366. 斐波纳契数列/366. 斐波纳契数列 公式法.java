public class Solution {
    /**
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
        double glodenRatio = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round(Math.pow(glodenRatio, n - 1) / Math.sqrt(5));
    }
}