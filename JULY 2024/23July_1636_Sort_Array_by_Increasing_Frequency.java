import java.util.*;

class Solution {
    // TC:O(NlogN) SC:O(N)
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int ele : nums) {
            ans.add(ele);
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        Collections.sort(ans, (a, b) -> {
            int countCompare = Integer.compare(map.get(a), map.get(b));
            return countCompare != 0 ? countCompare : Integer.compare(b, a);
        });
        return ans.stream().mapToInt(i -> i).toArray(); // O(n)
    }
}