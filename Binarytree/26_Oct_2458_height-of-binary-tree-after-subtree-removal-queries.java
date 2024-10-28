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
// TC:O(N)+O(M) n=no of nodes+M=queries.legnth()
// SC:O(N)+O(N)+O(N)+O(N)=>O(4N) wrost case
class Solution {
    int level[] = new int[100001];
    int height[] = new int[100001];
    int levelMaxHeight[] = new int[100001];
    int levelSecMaxHeight[] = new int[100001];

    private int findHeight(TreeNode root, int currLevel) {
        if (root == null)
            return 0;
        // level of curr node
        level[root.val] = currLevel;
        // height of curr node
        height[root.val] = 1 + Math.max(findHeight(root.left, currLevel + 1), findHeight(root.right, currLevel + 1));

        // find MAX and SECMAX height
        if (levelMaxHeight[currLevel] < height[root.val]) {
            levelSecMaxHeight[currLevel] = levelMaxHeight[currLevel];
            levelMaxHeight[currLevel] = height[root.val];
        } else if (levelSecMaxHeight[currLevel] < height[root.val]) {
            levelSecMaxHeight[currLevel] = height[root.val];
        }

        return height[root.val];
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        int ans[] = new int[n];
        int idx = 0;
        findHeight(root, 0);// root level is 0
        /// find node level
        for (int val : queries) {
            // node's level that we hv to delete
            int L = level[val];
            // L+H-1
            int temp = L + (levelMaxHeight[L] == height[val] ? levelSecMaxHeight[L] : levelMaxHeight[L]) - 1;
            ans[idx++] = temp;

        }
        return ans;
    }
}