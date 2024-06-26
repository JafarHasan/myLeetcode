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
    // This is not a inplaced solution
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return makeBalancedBST(0, list.size() - 1, list);
    }

    // TC:O(N) SC:O(N+N)+>O(N) stack and ArrayList
    public void inOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    // converting the sorted array to BST
    // TC:O(N) SC:O(N) stack
    public TreeNode makeBalancedBST(int si, int ei, ArrayList<Integer> list) {
        if (si > ei)
            return null;
        int mid = si + (ei - si) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = makeBalancedBST(si, mid - 1, list);
        root.right = makeBalancedBST(mid + 1, ei, list);
        return root;
    }
}

// OverAll TC:O(N) SC:O(N)