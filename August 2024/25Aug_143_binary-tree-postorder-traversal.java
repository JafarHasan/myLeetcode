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
    // TC:O(N) SC:O(N)->for Stack n=no of nodes
    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;

        }
        helper(root.left, list);
        helper(root.right, list);
        list.add(root.val);

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
}