
import java.util.List;
//Definition for a binary tree node.
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {
//     }

//     TreeNode(int val) {
//         this.val = val;
//     }

//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    // TC:O(N) SC:O(N)->for Stack n=no of nodes
    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;

        }
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
}