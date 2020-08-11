import java.util.LinkedList;
import java.util.List;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.right == null) {
                ans.add(0, cur.val);
                cur = cur.left;
            }
            else {
                pre = cur.right;
                while (pre.left != null && pre.left != cur) pre = pre.left;
                if (pre.left == null) {
                    ans.add(0, cur.val);
                    pre.left = cur;
                    cur = cur.right;
                }
                else {
                    pre.left = null;
                    cur = cur.left;
                }
            }
        }
        return ans;
    }
}