package Binarytree;

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
    int sum = 0;

    // TC:O(N) SC:O(N) 100% beats 0ms
    private void solve(TreeNode root, boolean isLeft) {
        if (root == null)
            return;
        if (isLeft && root.left == null && root.right == null) {
            sum += root.val;
        }
        solve(root.left, true);
        solve(root.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        solve(root, false);
        return sum;
    }
}