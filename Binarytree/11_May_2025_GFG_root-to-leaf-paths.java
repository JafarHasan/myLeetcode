
import java.util.*;

class Solution {

    private static void solve(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.data);
        //a leaf node
        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(list));

        } else {

            solve(root.left, ans, list);
            solve(root.right, ans, list);
        }
        list.remove(list.size() - 1);

    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(root, ans, new ArrayList<>());
        return ans;

    }
}
