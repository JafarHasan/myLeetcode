import java.util.ArrayList;
import java.util.List;

class Solution {
    // TC:O(2^n) SC:O(n)
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        solve(1, n, k, temp);
        return ans;

    }

    public void solve(int start, int n, int k, List<Integer> temp) {
        if (k == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (start > n)
            return;

        // pick
        temp.add(start);
        solve(start + 1, n, k - 1, temp);

        // not pick
        temp.remove(temp.size() - 1);
        solve(start + 1, n, k, temp);

    }
}