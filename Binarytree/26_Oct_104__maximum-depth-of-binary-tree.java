package Binarytree;

class Solution2 {
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int la = maxDepth(root.left);
        int ra = maxDepth(root.right);
        return 1 + Math.max(la, ra);
    }

    public int maxDepth(TreeNode root) {
        return (root == null) ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }
}