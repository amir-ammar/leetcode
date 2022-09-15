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
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        ans.add(new ArrayList<>());
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int prev = 1;
        int coming = 0;
        while (!q.isEmpty()) {

            TreeNode tmp = q.poll();
            
            if (tmp.left != null) {
                q.add(tmp.left);
                coming++;
            }

            if (tmp.right != null) {
                q.add(tmp.right);
                coming++;
            }

            ans.get(ans.size() - 1).add(tmp.val);
            prev--;

            if (prev == 0) {
                if(coming != 0)ans.add(new ArrayList<>());
                prev = coming;
                coming = 0;
            }
            
        }
        return ans;
    }
}