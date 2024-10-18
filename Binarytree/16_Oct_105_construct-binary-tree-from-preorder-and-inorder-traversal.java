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
// TC:O(N) SC:(H) orSC:O(N) for Map
class Solution {
    int preIdx;

    private TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preIdx++]);
        int idx = map.get(root.val);
        root.left = build(preorder, inorder, inStart, idx - 1, map);
        root.right = build(preorder, inorder, idx + 1, inEnd, map);
        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        preIdx = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, map);

    }
}