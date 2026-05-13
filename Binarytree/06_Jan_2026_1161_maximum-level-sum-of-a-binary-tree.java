
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxSum = Integer.MIN_VALUE;
        int res = 0;
        int level = 1;//root already added
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            while (size-- > 0) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            if (sum > maxSum) {
                maxSum = sum;
                res = level;
            }
            level++;
        }
        return res;
    }
}
