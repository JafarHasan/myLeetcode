
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

    TreeNode solve(int preStart, int postStart, int preEnd, int[] pre, int[] post) {
        if (preStart > preEnd) {
            return null;
        }
        // make root from preOrder start
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        int nextNode = pre[preStart + 1];// root of left subtree

        int j = postStart;
        while (post[j] != nextNode) {
            j++;
        }
        int num = j - postStart + 1;
        root.left = solve(preStart + 1, postStart, preStart + num, pre, post);
        root.right = solve(preStart + num + 1, j + 1, preEnd, pre, post);

        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return solve(0, 0, n - 1, preorder, postorder);
    }
}
