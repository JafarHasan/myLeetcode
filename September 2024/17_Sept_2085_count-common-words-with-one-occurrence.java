import java.util.HashMap;

class Solution {
    // using Two HashMap
    // TC:O(N) SC:O(N)
    public int countWords(String[] words1, String[] words2) {
        int cnt = 0;
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String s : words1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (String s : words2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && map1.get(key) == 1 && map2.get(key) == 1) {
                cnt++;
            }
        }
        return cnt;

    }
}