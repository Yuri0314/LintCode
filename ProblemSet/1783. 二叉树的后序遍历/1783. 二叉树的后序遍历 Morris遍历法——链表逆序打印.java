import java.util.ArrayList;
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
    private List<Integer> ans = new ArrayList<Integer>();
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left == null) cur = cur.right;
            else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) pre = pre.right;
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                else {
                    pre.right = null;
                    traverseEdge(cur.left);
                    cur = cur.right;
                }
            }
        }
        traverseEdge(root);
        return ans;
    }

    private void traverseEdge(TreeNode node) {
        TreeNode cur = reverseEdge(node);
        node = cur;
        while (cur != null) {
            ans.add(cur.val);
            cur = cur.right;
        }
        reverseEdge(node);
    }

    private TreeNode reverseEdge(TreeNode node) {
        TreeNode pre = null, cur = node;
        while (cur != null) {
            node = cur.right;
            cur.right = pre;
            pre = cur;
            cur = node;
        }
        return pre;
    }
}