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
        Stack<TreeNodePair> stack = new Stack<TreeNodePair>();
        stack.push(new TreeNodePair(root, false));
        while (!stack.isEmpty()) {
            TreeNodePair pair = stack.pop();
            if (!pair.flag) {
                stack.push(new TreeNodePair(pair.node, true));
                if (pair.node.right != null) stack.push(new TreeNodePair(pair.node.right, false));
                if (pair.node.left != null) stack.push(new TreeNodePair(pair.node.left, false));
            }
            else {
                ans.add(pair.node.val);
            }
        }
        return ans;
    }

    private class TreeNodePair {
        TreeNode node;
        boolean flag;
        TreeNodePair(TreeNode node, boolean flag) {
            this.node = node;
            this.flag = flag;
        }
    }
}