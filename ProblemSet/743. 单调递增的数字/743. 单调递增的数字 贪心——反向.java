public class Solution {
    /**
     * @param num: a non-negative integer N
     * @return: the largest number that is less than or equal to N with monotone increasing digits.
     */
    public int monotoneDigits(int num) {
        char[] str = String.valueOf(num).toCharArray();
        int pos = str.length;   // pos表示从末尾起最左边的违反单调递增的位置
        for (int i = str.length - 1; i > 0; --i) {
            if (str[i - 1] > str[i]) {
                --str[i - 1];
                pos = i;
            }
        }
        for (int i = pos; i < str.length; ++i)
            str[i] = '9';
        return Integer.parseInt(String.valueOf(str));
    }
}