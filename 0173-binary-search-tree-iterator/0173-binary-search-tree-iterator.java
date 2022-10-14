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
class BSTIterator {

    TreeNode iterator;
    Queue<Integer> traversal;

    public BSTIterator(TreeNode root) {
        iterator = root;
        traversal = new ArrayDeque<>();
        fillStack(iterator);
    }

    public void fillStack(TreeNode iterator){
        if (iterator.left != null) {
            fillStack(iterator.left);
        }
        traversal.add(iterator.val);
        if (iterator.right != null) {
            fillStack(iterator.right);
        }
    }

    public int next() {
        while (!traversal.isEmpty()) {
            return traversal.poll();
        }
        return -1;
    }

    public boolean hasNext() {
        return !traversal.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */