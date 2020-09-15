import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: an integer
     * @return:  the factorial of n
     */
    public String factorial(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(1);
        for (int i = 2; i <= n; ++i) {
            // 给结果的每一位都乘上当前数
            for (int j = 0; j < ans.size(); ++j)
                ans.set(j, ans.get(j) * i);
            // 从低位开始对整个数每一位进行进位操作
            for (int j = 0; j < ans.size() - 1; ++j) {
                int cur = ans.get(j);
                ans.set(j + 1, ans.get(j + 1) + cur / 10);
                ans.set(j, cur % 10);
            }
            // 如果此时最高位大于9，则增加新的最高位
            int highest = ans.get(ans.size() - 1);
            while (highest > 9) {
                ans.set(ans.size() - 1, highest % 10);
                highest /= 10;
                ans.add(highest);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = ans.size() - 1; i >= 0; --i)
            sb.append((char)('0' + ans.get(i)));
        return sb.toString();
    }
}