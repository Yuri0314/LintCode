public class Solution {
    /**
     * @param num: a non-negative integer N
     * @return: the largest number that is less than or equal to N with monotone increasing digits.
     */
    public int monotoneDigits(int num) {
        char[] str = String.valueOf(num).toCharArray();
        int pos = 1;
        while (pos < str.length && str[pos - 1] <= str[pos]) ++pos;
        if (pos != str.length) {    // 如果不是到达结尾，说明原数字并不是单调递增的
            while (pos > 0 && str[pos - 1] > str[pos]) --str[--pos];
            while (pos < str.length - 1) str[++pos] = '9';
        }
        return Integer.parseInt(String.valueOf(str));
    }
}