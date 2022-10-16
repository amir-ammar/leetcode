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
    public static int sumNumbers(TreeNode root) {
        total = 0;
        helper(root, new StringBuilder());
        return total;
    }
    static int total;
    public static void helper(TreeNode root, StringBuilder sum) {
        if (root == null) return;
        sum.append(root.val);
        helper(root.left, sum);
        helper(root.right, sum);
        if (root.left == null && root.right == null) total += Integer.parseInt(sum.toString());
        sum.deleteCharAt(sum.length() - 1);
    }
}