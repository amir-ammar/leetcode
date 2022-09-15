/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public static boolean helper(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return helper(root.left, p) || helper(root.right, p);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode ans = null;
        TreeNode left = null;
        TreeNode right = null;
        if (helper(root, p) && helper(root, q)) {
            ans = root;
            left = lowestCommonAncestor(root.left, p, q);
            right = lowestCommonAncestor(root.right, p, q);
        }
        return left != null ? left : (right != null ? right : ans);
    }
}