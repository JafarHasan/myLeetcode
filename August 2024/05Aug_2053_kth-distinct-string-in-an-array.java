import java.util.*;

class Solution {
    // TC:o(n) SC:O(n) n=arr.length
    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        if (map.size() < k)
            return "";
        for (String key : map.keySet()) {

            if (map.get(key) == 1) {
                k--;
            }
            if (k == 0)
                return key;
        }
        return "";
    }
}