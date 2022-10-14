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
    public static TreeNode constructTree(TreeNode oldOne, TreeNode newOne, int forward){

        newOne.val = sumRight(oldOne, 0) + forward;

        if (oldOne.right != null) {
            newOne.right = new TreeNode();
            constructTree(oldOne.right, newOne.right, forward);
        }
        if (oldOne.left != null) {
            newOne.left = new TreeNode();
            constructTree(oldOne.left, newOne.left, newOne.val);
        }
        return newOne;
    }


    public static int sumRight(TreeNode root, int f) {
        if (root == null) return 0;
        int ans = root.val;
        ans += sumRight(root.right, f+1);
        if (f != 0) ans += sumRight(root.left, f+1);
        return ans;
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        return constructTree(root, new TreeNode(), 0);
    }
}