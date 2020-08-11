import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (root.left != null && root.left != pre && root.right != pre) stack.push(root.left);
            else if (root.right != null && root.right != pre) stack.push(root.right);
            else {
                ans.add(stack.pop().val);
                pre = root;
            }
        }
        return ans;
    }
}