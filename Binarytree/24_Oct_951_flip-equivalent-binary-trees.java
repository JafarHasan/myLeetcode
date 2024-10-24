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
    public boolean flipEquivHelper(TreeNode root1, TreeNode root2) {
        // Base cases
        if (root1 == null && root2 == null)
            return true; // Both are null, they are equivalent
        if (root1 == null || root2 == null)
            return false; // One is null, the other is not, not equivalent
        if (root1.val != root2.val)
            return false; // Values are different, not equivalent

        // Check if subtrees are flip equivalent without flipping or with flipping
        boolean noFlip = flipEquivHelper(root1.left, root2.left) && flipEquivHelper(root1.right, root2.right);
        boolean flip = flipEquivHelper(root1.left, root2.right) && flipEquivHelper(root1.right, root2.left);
        return noFlip || flip;
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return flipEquivHelper(root1, root2);
    }
}