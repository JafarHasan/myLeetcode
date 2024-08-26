/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        // if both are smaller than root/node then they both will lie on the left side
        // of the rooot/node
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // if both are greater than root/node then they both will lie on the right side
        // of the rooot/node
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // one is smaller and one is greater than root/node than path will be separated
        // from here hence its the last node which is common i e LCA

        else {
            return root;
        }

    }
}