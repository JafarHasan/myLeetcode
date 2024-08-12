import java.util.LinkedHashMap;

class Solution {
    // TC:O(N) SC:O(N)
    public int mostFrequentEven(int[] nums) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int ele : nums) {
            if (ele % 2 == 0) {
                map.put(ele, map.getOrDefault(ele, 0) + 1);
            }
        }
        if (map.size() == 0)
            return -1;
        int freq = -1;
        int ans = -1;
        for (int key : map.keySet()) {
            if (map.get(key) > freq) {
                freq = map.get(key);
                ans = key;

            }
            if (map.get(key) == freq && key < ans) {
                ans = key;
            }
        }

        return ans;
    }
}