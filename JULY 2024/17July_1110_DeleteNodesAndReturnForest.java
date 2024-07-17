import java.util.*;
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
    // TC:O(N) SC:O(N)
    public TreeNode deleteHelper(TreeNode root, HashSet<Integer> set, List<TreeNode> ansTree) {
        if (root == null) {
            return null;
        }
        root.left = deleteHelper(root.left, set, ansTree);
        root.right = deleteHelper(root.right, set, ansTree);

        if (set.contains(root.val)) {// so we hv to delete
            if (root.left != null) {
                ansTree.add(root.left);
            }
            if (root.right != null) {
                ansTree.add(root.right);
            }
            return null;// returning deleted node as null
        } else {
            // dont delete
            return root;
        }

    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ansTree = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        for (int ele : to_delete) {
            set.add(ele);
        }
        deleteHelper(root, set, ansTree);
        if (!set.contains(root.val)) {// we dont need to delete main root
            ansTree.add(root);

        }

        return ansTree;
    }
}