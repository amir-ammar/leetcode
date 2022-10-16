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

    public int kthSmallest(TreeNode root, int k) {
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(root.val);
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            if (tmp.left != null) {
                q.add(tmp.left);
                arr.add(tmp.left.val);
            }
            if (tmp.right != null) {
                q.add(tmp.right);
                arr.add(tmp.right.val);
            }
        }
        Collections.sort(arr);
        return arr.get(k - 1);
    }
}