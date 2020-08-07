import java.util.ArrayList;
import java.util.Deque;
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
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;
        Deque<TreeNode> cur = new LinkedList<TreeNode>();
        Deque<TreeNode> next = new LinkedList<TreeNode>();
        Deque<TreeNode> tmp;
        boolean normalOrder = true;
        cur.addLast(root);
        while (!cur.isEmpty()) {
            List<Integer> curAns = new ArrayList<Integer>();
            while (!cur.isEmpty()) {
                TreeNode node;
                if (normalOrder) {
                    node = cur.removeFirst();
                    if (node.left != null) next.addLast(node.left);
                    if (node.right != null) next.addLast(node.right);
                }
                else {
                    node = cur.removeLast();
                    if (node.right != null) next.addFirst(node.right);
                    if (node.left != null) next.addFirst(node.left);
                }
                curAns.add(node.val);
            }
            ans.add(curAns);
            tmp = cur;
            cur = next;
            next = tmp;
            normalOrder = !normalOrder;
        }
        return ans;
    }
}