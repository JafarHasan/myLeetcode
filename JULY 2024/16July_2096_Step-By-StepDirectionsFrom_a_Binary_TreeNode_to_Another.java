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

    public TreeNode findPath(TreeNode root, int value, ArrayList<TreeNode> al) {
        if (root == null) {
            return null;
        }
        if (root.val == value) {
            al.add(root);
            return root;
        }
        TreeNode filc = findPath(root.left, value, al);
        if (filc != null) {
            al.add(root);
            return filc;
        }

        TreeNode firc = findPath(root.right, value, al);
        if (firc != null) {
            al.add(root);
            return firc;
        }
        return null;

    }

    public String getDirections(TreeNode root, int startValue, int destValue) {

        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        findPath(root, startValue, path1);
        findPath(root, destValue, path2);

        int i = path1.size() - 1;
        int j = path2.size() - 1;
        TreeNode lca = null;
        while (i >= 0 && j >= 0) {
            if (path1.get(i).val == path2.get(j).val) {
                lca = path1.get(i);
            } else {
                break;
            }
            i--;
            j--;
        }
        // lca to src path
        // lca to dest path
        System.out.println(lca.val);
        StringBuilder s1 = new StringBuilder("");
        StringBuilder s2 = new StringBuilder("");

        lcaToNodePath(lca, startValue, s1);
        lcaToNodePath(lca, destValue, s2);

        System.out.println(s1);
        System.out.println(s2);
        StringBuilder s3 = new StringBuilder();
        int n = s1.length();
        while (n-- > 0) {
            s3.append("U");
        }
        s3.append(s2);
        return s3.toString();
    }

    public boolean lcaToNodePath(TreeNode lca, int src, StringBuilder sb) {
        if (lca == null) {
            return false;
        }
        if (lca.val == src)
            return true;
        // left
        boolean flag1 = lcaToNodePath(lca.left, src, sb.append("L"));
        if (flag1) {
            return true;
        }
        // if not find in left delete last added L
        sb.deleteCharAt(sb.length() - 1);

        // right
        boolean flag2 = lcaToNodePath(lca.right, src, sb.append("R"));
        if (flag2) {
            return true;
        }
        // if not find in right delete last added R
        sb.deleteCharAt(sb.length() - 1);
        return false;

    }
}