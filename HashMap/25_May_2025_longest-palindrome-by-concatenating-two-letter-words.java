import java.util.*;
class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int cnt = 0;
        int pali = 0;
        for (String s : map.keySet()) {
            String t = new StringBuilder(s).reverse().toString();
            int freq = map.get(s);
            if (s.equals(t)) {
                cnt += (freq / 2) * 4;
                if (freq % 2 == 1) {
                    pali = 1;
                }
            } else if (s.compareTo(t) < 0 && map.containsKey(t)) {
                cnt += Math.min(freq, map.get(t)) * 4;
            }
        }
        return cnt + pali * 2;
    }
}
