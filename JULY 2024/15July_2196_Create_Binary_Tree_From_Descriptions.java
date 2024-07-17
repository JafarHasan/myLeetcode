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
    public TreeNode createBinaryTree(int[][] des) {
        // 1-> left child
        // 0->right child
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();// they can never be root of the tree

        for (int[] row : des) {
            int parent = row[0];
            int child = row[1];
            int isLeft = row[2];

            // checking and creating node for parent
            if (!map.containsKey(parent)) {
                map.put(parent, new TreeNode(parent));
            }
            // checking and creating node for child
            if (!map.containsKey(child)) {
                map.put(child, new TreeNode(child));
            }

            if (isLeft == 1) {// if its a left child
                map.get(parent).left = map.get(child);// assigning left child to parent
            } else {
                map.get(parent).right = map.get(child);// assigning right child to parent
            }

            set.add(child);
        }
        // finding rooot
        for (int[] row : des) {
            int parent = row[0];
            if (!set.contains(parent)) {
                return map.get(parent);
            }
        }
        return null;// never reach here
    }
}