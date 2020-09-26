public class Solution {
    /**
     * @param a: the given number
     * @param b: another number
     * @return: the greatest common divisor of two numbers
     */
    public int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}