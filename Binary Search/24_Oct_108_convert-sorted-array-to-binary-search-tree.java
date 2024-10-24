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
    public TreeNode helper(int[] arr, int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;

        int val = arr[mid];
        TreeNode left = helper(arr, si, mid - 1);
        TreeNode right = helper(arr, mid + 1, ei);

        TreeNode root = new TreeNode(val, left, right);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        TreeNode root = helper(nums, 0, n - 1); /// arr,si,ei;
        return root;
    }
}