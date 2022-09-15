/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static boolean helper(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) return false;
        if (p == null) return true;
        return p.val == q.val && helper(p.left, q.left) && helper(p.right, q.right);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        boolean ans = false;
        if (root.val == subRoot.val) ans = helper(root, subRoot);
        return ans || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}