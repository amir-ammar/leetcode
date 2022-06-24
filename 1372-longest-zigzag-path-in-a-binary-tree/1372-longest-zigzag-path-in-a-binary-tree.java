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
    
    
    private enum Direction {
        LEFT,
        RIGHT
    }
    
    public static int helper(TreeNode root, int sum, Direction dir){ // false -> left, true -> right
        if(root == null) return sum - 1;
        int left = helper(root.left, dir == Direction.LEFT ? 1 : sum + 1, Direction.LEFT);
        int right = helper(root.right, dir == Direction.RIGHT ? 1 : sum + 1, Direction.RIGHT);
        return Math.max(left, right);
    }

    public int longestZigZag(TreeNode root) {
        return helper(root, 0, null);
    }
}