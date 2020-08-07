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
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return recursiveBuild(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private int findRootPos(int[] order, int start, int end, int root) {
        for (int i = start; i <= end; ++i) {
            if (order[i] == root)
                return i;
        }
        return -1;
    }

    private TreeNode recursiveBuild(int[] inorder, int inStart, int inEnd,
                                int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) return null;
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootPos = findRootPos(inorder, inStart, inEnd, rootVal);
        int leftLen = rootPos - inStart;
        root.left = recursiveBuild(inorder, inStart, rootPos - 1, postorder, postStart, postStart + leftLen - 1);
        root.right = recursiveBuild(inorder, rootPos + 1, inEnd, postorder, postStart + leftLen, postEnd - 1);
        return root;
    }
}