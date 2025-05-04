
import java.util.*;
class Solution {

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        for (int d[] : dominoes) {
            String s = "";
            if (d[0] > d[1]) {
                s = d[1] + "" + d[0];
            } else {
                s = d[0] + "" + d[1];
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int ans = 0;
        //System.out.println(map);
        for (int val : map.values()) {
            ans += val * (val - 1) / 2;
        }
        return ans;
    }
}
