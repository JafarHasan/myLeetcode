
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

    // Global pointer to track the current index in the traversal string.
    int index = 0;

    private TreeNode dfs(String s, int depth) {
        int n = s.length();
        int i = index;
        int d = 0;
        // Count the number of '-' characters (i.e. the depth marker)
        while (i < n && s.charAt(i) == '-') {
            d++;
            i++;
        }
        // If the number of dashes doesn't match the expected depth, return null.
        if (d != depth) {
            return null;
        }

        // Parse the number.
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            i++;
        }
        // Create the current node.
        TreeNode node = new TreeNode(num);
        // Update the global index.
        index = i;

        // Recursively build the left subtree.
        node.left = dfs(s, depth + 1);
        // Recursively build the right subtree.
        node.right = dfs(s, depth + 1);

        return node;
    }

    public TreeNode recoverFromPreorder(String traversal) {
        index = 0;
        return dfs(traversal, 0);
    }
}
