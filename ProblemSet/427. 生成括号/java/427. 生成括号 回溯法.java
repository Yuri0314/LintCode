import java.util.List;
import java.util.ArrayList;

public class Solution {
    private int n;
    private List<String> ans;
    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.ans = new ArrayList<String>();
        backtrace(new StringBuilder(), 0, 0);
        return ans;
    }

    private void backtrace(StringBuilder cur, int left_num, int right_num) {
        if (cur.length() == 2 * this.n) {
            this.ans.add(cur.toString());
            return;
        }
        if (left_num < this.n) {
            cur.append('(');
            backtrace(cur, left_num + 1, right_num);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right_num < left_num) {
            cur.append(')');
            backtrace(cur, left_num, right_num + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}