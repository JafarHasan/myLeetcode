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

    // 1 times BFS pass
    // TC:=O(N) SC:O(N) N=no of nodes
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int levelSum = root.val;

        // BFS
        while (!q.isEmpty()) {
            int size = q.size();
            int nextLevelSum = 0;
            while (size-- > 0) {
                TreeNode curr = q.poll();
                curr.val = levelSum - curr.val;
                // find silblings sum
                int siblingSum = curr.left != null ? curr.left.val : 0;
                siblingSum += curr.right != null ? curr.right.val : 0;
                if (curr.left != null) {
                    nextLevelSum += curr.left.val;
                    curr.left.val = siblingSum;
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    nextLevelSum += curr.right.val;
                    curr.right.val = siblingSum;
                    q.add(curr.right);
                }
            }
            levelSum = nextLevelSum;
        }
        return root;
    }

}

class Solution2 {

    // 2 times BFS pass
    // TC:O(2N) =O(N) SC:O(NxL) L=no of Levels N=no of nodes
    public TreeNode replaceValueInTree(TreeNode root) {
        ArrayList<Integer> levelsSum = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // BFS
        while (!q.isEmpty()) {
            int size = q.size();
            int currLevelSum = 0;
            while (size-- > 0) {
                TreeNode curr = q.poll();
                currLevelSum += curr.val;

                // Add left and right children to the queue
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

            }
            levelsSum.add(currLevelSum); // at root level sum is only root value

        }

        // II pass
        // q has been empty
        int currLevel = 0;
        q.add(root);// root has no cousin
        root.val = 0;// 1 level completed
        currLevel++;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode curr = q.poll();
                int siblingSum = curr.left != null ? curr.left.val : 0;
                siblingSum += curr.right != null ? curr.right.val : 0;

                if (curr.left != null) {
                    curr.left.val = levelsSum.get(currLevel) - siblingSum;
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    curr.right.val = levelsSum.get(currLevel) - siblingSum;
                    q.add(curr.right);
                }

            }
            currLevel++;
        }
        return root;
    }

}