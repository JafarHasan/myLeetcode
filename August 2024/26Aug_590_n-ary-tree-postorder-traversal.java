/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    // TC:O(N) SC:o(N)
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        postOrder(root, ans);
        return ans;
    }

    private void postOrder(Node root, List<Integer> ans) {
        for (Node n : root.children) {
            postOrder(n, ans);
        }
        ans.add(root.val);
    }

}