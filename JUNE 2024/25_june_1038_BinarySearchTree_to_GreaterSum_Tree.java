class Solution {
    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }

    /// TC:O(N) we are visiting each node 1 time only SC:O(N) for recursive stack
    public void helper(TreeNode root, int maxSoFar) {
        if (root == null)
            return;
        helper(root.right, maxSoFar);
        root.val = root.val + maxSoFar;
        maxSoFar = Math.max(maxSoFar, root.val);
        helper(root.left, maxSoFar);
    }
}