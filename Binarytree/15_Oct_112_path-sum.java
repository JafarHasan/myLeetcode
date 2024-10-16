package Binarytree;

class Solution {
    // TC:O(N) SC:O(N)
    private boolean solve(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        // now we are on a leaf node so target should be = to leaf val
        if (root.right == null && root.left == null)
            return targetSum == root.val;
        return solve(root.left, targetSum - root.val) || solve(root.right, targetSum - root.val);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum);
    }
}