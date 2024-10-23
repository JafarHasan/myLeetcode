/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // TC:O(N) SC:O(N)
    private void helper(TreeNode root, TreeNode parent, int[] sum) {
        if (root == null)
            return;
        // parent -> root(currNode) ->left child|right Child

        // if parent means left and right child grand Parent is not null and even so add
        // left child right child value
        if (root.left != null && parent != null && parent.val % 2 == 0) {
            sum[0] += root.left.val;
        }
        if (root.right != null && parent != null && parent.val % 2 == 0) {
            sum[0] += root.right.val;
        }

        helper(root.left, root, sum);
        helper(root.right, root, sum);

    }

    public int sumEvenGrandparent(TreeNode root) {
        // your code here
        int[] sum = new int[1];
        helper(root, null, sum);
        return sum[0];
    }
}