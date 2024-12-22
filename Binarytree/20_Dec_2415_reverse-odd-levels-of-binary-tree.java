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
    //DFS TC:O(N) SC:O(N) beats 100%
    private void solve(TreeNode root1,TreeNode root2,boolean isOdd){
        if(root1==null || root2==null)return ;
        //if its a odd level swap the node
        if(isOdd){
            //swap nodes
            int temp=root1.val;
            root1.val=root2.val;
            root2.val=temp;

        }
        
        solve(root1.left,root2.right,!isOdd);
        solve(root1.right,root2.left,!isOdd);
    }
    // DFS TC:O(N) SC:O(n) N=no of nodes beats 42.99%
    public TreeNode reverseOddLevels(TreeNode root) {
        //we are passing from 2nd nodes means level 1 and its odd
        solve(root.left,root.right,true);
        return root;

    }
}
class Solution2 {
    // BFS TC:O(N) SC:O(n) N=no of nodes beats 42.99%
    public TreeNode reverseOddLevels(TreeNode root) {
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                TreeNode curr = q.poll();

                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            // next Level
            level++;
            if (level % 2 == 1 && !q.isEmpty()) {
                int arr[] = new int[q.size()];
                int i = 0;
                for (TreeNode node : q) {
                    arr[i++] = node.val;
                }
                int j = q.size() - 1;
                for (TreeNode node : q) {
                    node.val = arr[j--];
                }

            }

        }
        return root;

    }

}