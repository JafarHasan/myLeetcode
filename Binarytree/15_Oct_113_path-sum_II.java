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
    // Binary Tree + Backtracking
    List<List<Integer>> ansList;

    // TC:O(N) SC:O(N)
    private void solve(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null)
            return;
        // now we are on a leaf node so target should be = to leaf val if
        // it is so we got one path add it to out ans
        list.add(root.val);
        if (root.right == null && root.left == null) {
            if (targetSum == root.val) {
                ansList.add(new ArrayList<>(list));
            }
        }
        solve(root.left, targetSum - root.val, list);
        solve(root.right, targetSum - root.val, list);

        // backtracking after removing last element we had added
        list.remove(list.size() - 1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ansList = new ArrayList<>();
        solve(root, targetSum, new ArrayList<>());
        return ansList;
    }
}