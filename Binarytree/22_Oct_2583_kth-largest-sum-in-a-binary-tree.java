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
import java.util.*;

class Solution {
    // TC:O(N) N=no of nodes
    // SC:O(H) height of max no of nodes in a Level
    public long kthLargestLevelSum(TreeNode root, int k) {
        // PriorityQueue<Long> pq=new PriorityQueue<>((a,b)->b-a);//error
        // PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        // // Max heap

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());// max heap
        /// for BFS
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);// q.insert(root);
        while (!q.isEmpty()) {
            int size = q.size();
            // starting a new Level
            long sumOfCurrLevel = 0;
            while (size-- > 0) {
                TreeNode curr = q.poll();
                sumOfCurrLevel += curr.val; // adding values of a Level

                // if left exists
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                // if right exists
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            pq.add(sumOfCurrLevel);
        }
        long kthSum = 0;
        while (k-- > 0) {
            // if there are fewer element tham K in PQ return -1
            if (pq.isEmpty())
                return -1;
            kthSum = pq.poll();
        }
        return kthSum;
    }
}