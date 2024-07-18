import java.util.*;

//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // TC:O(N^2) SC:O(N)
    public int countPairs(TreeNode root, int distance) {
        // make an undirected graph and store all leaf ndoes
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        HashSet<TreeNode> set = new HashSet<>();
        findLeaves(root, null, set, map); // making graph O(N)

        // shortest distance between all leaf nodes and cnt those if <=distance
        int cnt = 0;/// cnt of good node pair

        for (TreeNode leaf : set) { // O(N^2)
            // BFS and see if u can find another leaf node within distance
            Queue<TreeNode> q = new LinkedList<>();
            HashSet<TreeNode> vis = new HashSet<>();

            q.offer(leaf);
            vis.add(leaf);

            for (int level = 0; level <= distance; level++) {
                int size = q.size();
                while (size-- > 0) {
                    TreeNode curr = q.poll();
                    if (curr != leaf && set.contains(curr)) {
                        cnt++;
                    }

                    for (TreeNode nbr : map.get(curr)) {
                        if (!vis.contains(nbr)) {
                            q.offer(nbr);
                            vis.add(nbr);// visited
                        }
                    }
                }
            }

        }
        return cnt / 2;

    }

    private void findLeaves(TreeNode node, TreeNode prevNode, HashSet<TreeNode> set,
            Map<TreeNode, List<TreeNode>> map) {
        if (node == null)
            return;

        // Initialize the adjacency list for the current node
        map.putIfAbsent(node, new ArrayList<>());

        // //its a leaf node
        if (node.left == null && node.right == null) {
            set.add(node);

        }
        if (prevNode != null) {
            map.get(node).add(prevNode);
            map.get(prevNode).add(node);
        }
        findLeaves(node.left, node, set, map);
        findLeaves(node.right, node, set, map);
    }

}