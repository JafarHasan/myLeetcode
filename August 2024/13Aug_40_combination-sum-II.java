import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // TC:O(2^n) SC:O(n)
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        Arrays.sort(cand);
        solve(cand, target, sub, 0, result);

        return result;

    }

    public void solve(int[] cand, int t, List<Integer> curr, int idx, List<List<Integer>> result) {
        if (t < 0)
            return;
        if (t == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < cand.length; i++) {
            // avoiding dulpicates
            if (i > idx && cand[i] == cand[i - 1]) {
                continue;
            }
            if (cand[i] > t)
                break;

            // pick and explore
            curr.add(cand[i]);
            solve(cand, t - cand[i], curr, i + 1, result);

            // not pick
            curr.remove(curr.size() - 1);

        }
    }
}