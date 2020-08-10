import java.util.ArrayList;
import java.util.List;

/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    private List<Integer> ans = new ArrayList<Integer>();
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return ans;
    }

    public void traverse(TreeNode root) {
        if (root != null) {
            traverse(root.left);
            ans.add(root.val);
            traverse(root.right);
        }
    }
}