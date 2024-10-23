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
// TC:O(N) SC:O(N)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        // BFS level order Traversal
        while (que.size() > 0) {
            int size = que.size();
            boolean fx = false;
            boolean fy = false;

            while (size-- > 0) {
                TreeNode curr = que.poll();// remove()
                if (curr.val == x)
                    fx = true;
                if (curr.val == y)
                    fy = true;

                // if Parent same then not cousins
                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) ||
                            (curr.left.val == y && curr.right.val == x)) {
                        return false;
                    }
                }
                // adding the left child
                if (curr.left != null) {
                    que.offer(curr.left);
                }

                // adding the right child
                if (curr.right != null) {
                    que.offer(curr.right);
                }
            }
            if (fx == true && fy == true)
                return true;
        }
        return false;
    }

}

class Solution2 {
    class Pair {
        TreeNode parent;
        TreeNode node;

        Pair(TreeNode n, TreeNode p) {
            this.parent = p;
            this.node = n;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, null));

        while (!q.isEmpty()) {
            int size = q.size();
            // Track Parent in each level
            TreeNode parentX = null, parentY = null;
            boolean xFound = false;
            boolean yFound = false;

            while (size-- > 0) {
                Pair p = q.poll();
                TreeNode curr = p.node;
                TreeNode currParent = p.parent;

                // find X ,store X parent
                if (curr.val == x) {
                    xFound = true;
                    parentX = currParent;
                }
                // find Y, store Y parent
                if (curr.val == y) {
                    yFound = true;
                    parentY = currParent;
                }

                if (xFound == true && yFound == true)
                    break;

                if (curr.left != null) {
                    q.add(new Pair(curr.left, curr));

                }
                if (curr.right != null) {
                    q.add(new Pair(curr.right, curr));
                }
            }
            // one level end ,now check if both parent are found or they should be diferent
            if (parentX != null && parentY != null) {
                return parentX != parentY;
            }
            // if one found one not so they cant be cousing bcz level will be different
            if (parentX != null || parentY != null)
                return false;
        }

        return false;
    }
}