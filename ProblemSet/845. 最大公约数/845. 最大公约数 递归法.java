public class Solution {
    /**
     * @param a: the given number
     * @param b: another number
     * @return: the greatest common divisor of two numbers
     */
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}