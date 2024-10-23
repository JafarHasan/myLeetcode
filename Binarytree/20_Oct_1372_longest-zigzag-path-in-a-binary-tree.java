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
    int maxZigZag = 0;

    private void solve(TreeNode root, boolean leftDir, int length) {
        if (root == null)
            return;
        maxZigZag = Math.max(maxZigZag, length);
        if (leftDir) {
            /// move towars right
            solve(root.left, false, length + 1);
            solve(root.right, true, 1);// start a new Path
        } else {
            /// move towars left
            solve(root.right, true, length + 1);
            solve(root.left, false, 1);
        }
    }

    public int longestZigZag(TreeNode root) {
        // Start zigzag from both left and right direction
        solve(root.left, false, 1); // Assume we moved left initially
        solve(root.right, true, 1); // Assume we moved right initially
        return maxZigZag;
    }
}