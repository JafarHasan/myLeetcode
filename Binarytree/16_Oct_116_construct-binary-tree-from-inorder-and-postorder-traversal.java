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
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        int n = inorder.length;
        // find root index in inorder[]
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (inStart > inEnd)
            return null;

        // The last element in postorder is the root
        TreeNode root = new TreeNode(postorder[postIndex--]);

        // Find the index of the root in inorder
        int inIndex = map.get(root.val);

        // Build the right subtree first (since we are using postorder)
        root.right = build(inorder, postorder, inIndex + 1, inEnd, map);
        // Build the left subtree
        root.left = build(inorder, postorder, inStart, inIndex - 1, map);

        return root;
    }

}

// using HashMap to avoid searching index in inorder
// TC:O(N) SC:O(H)
class Solution1 {
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd,
            HashMap<Integer, Integer> map) {
        if (inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = map.get(root.val);
        int leftSize = idx - inStart;
        int rightSize = inEnd - idx;

        root.left = buildTreeHelper(inorder, postorder, inStart, idx - 1, postStart, postStart + leftSize - 1, map);
        root.right = buildTreeHelper(inorder, postorder, idx + 1, inEnd, postEnd - rightSize, postEnd - 1, map);

        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        // find root index in inorder[]
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, postorder, 0, n - 1, 0, n - 1, map);
    }
}

// using index searching
class Solution2 {
    // TC:O(N^2) SC:O(H)
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart,
            int postEnd) {
        if (inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = inStart;
        for (int i = idx; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                idx = i;
                break;
            }
        }
        int leftSize = idx - inStart;
        int rightSize = inEnd - idx;

        root.left = buildTreeHelper(inorder, postorder, inStart, idx - 1, postStart, postStart + leftSize - 1);
        root.right = buildTreeHelper(inorder, postorder, idx + 1, inEnd, postEnd - rightSize, postEnd - 1);

        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        // find root index in inorder[]

        return buildTreeHelper(inorder, postorder, 0, n - 1, 0, n - 1);
    }
}