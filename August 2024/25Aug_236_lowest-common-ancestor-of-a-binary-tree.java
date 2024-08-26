class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;

        if (root == p || root == q) {
            return root;
        }
        // find leftNode from left side
        TreeNode leftN = lowestCommonAncestor(root.left, p, q);

        // find rightNode from right side
        TreeNode rightN = lowestCommonAncestor(root.right, p, q);

        if (leftN != null && rightN != null)
            return root;

        if (leftN != null)
            return leftN;

        return rightN;
    }
}