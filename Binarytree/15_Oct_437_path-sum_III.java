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
    /**
     * TC:O(N^2) SC:O(H) H=height of tree N=no of nodes
     */
    int ans = 0;

    private void checkPathSum(TreeNode root, int sum, long currSum) {
        if (root == null)
            return;
        // now we are on a leaf node so target should be = to leaf val
        currSum += root.val;
        if (currSum == sum) {
            ans++;
        }
        ;
        checkPathSum(root.left, sum, currSum);
        checkPathSum(root.right, sum, currSum);
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        checkPathSum(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return ans;

    }
}

class Solution2 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        return helper(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int helper(TreeNode root, long sum) {
        if (root == null)
            return 0;
        return (sum - root.val == 0 ? 1 : 0) + helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
    }
}