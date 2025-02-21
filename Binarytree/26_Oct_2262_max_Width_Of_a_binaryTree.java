
import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    class Pair {

        TreeNode node;
        int idx;

        Pair(TreeNode n, int i) {
            this.node = n;
            this.idx = i;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        // your code here
        Deque<Pair> q = new LinkedList<>();//to get the (last-first+1)
        int mxLen = 0;
        int idx = 0;
        q.add(new Pair(root, idx));
        while (!q.isEmpty()) {
            int size = q.size();
            // q id having one complete level
            int len = q.peekLast().idx - q.peek().idx + 1;// rightidx-leftidx+1
            mxLen = Math.max(mxLen, len);

            // Process all nodes in the current level.
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                TreeNode curr = p.node;
                int index = p.idx;

                // Add children with the corresponding index values.
                if (curr.left != null) {
                    q.add(new Pair(curr.left, 2 * index + 1));
                }
                if (curr.right != null) {
                    q.add(new Pair(curr.right, 2 * index + 2));
                }
            }

        }
        return mxLen;
    }
}
