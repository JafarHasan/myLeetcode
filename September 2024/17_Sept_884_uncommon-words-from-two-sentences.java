import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    // using only one HashMap
    // TC:O(N) SC:O(N) beats 100%
    public String[] uncommonFromSentences(String s1, String s2) {
        int cnt = 0;
        HashMap<String, Integer> map1 = new HashMap<>();

        String ss1[] = s1.split(" ");
        String ss2[] = s2.split(" ");
        ArrayList<String> list = new ArrayList<>();

        for (String s : ss1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (String s : ss2) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        /// All words which appears only one time
        for (String key : map1.keySet()) {
            if (map1.get(key) == 1)
                list.add(key);
            cnt++;
        }

        String ans[] = new String[list.size()];
        int idx = 0;
        for (String ele : list) {
            ans[idx++] = ele;
        }
        return ans;

    }
}

class Solution2 {
    // using two HashMap
    // TC:O(N) SC:O(N)
    public String[] uncommonFromSentences(String s1, String s2) {
        int cnt = 0;
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        String ss1[] = s1.split(" ");
        String ss2[] = s2.split(" ");
        ArrayList<String> list = new ArrayList<>();

        for (String s : ss1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (String s : ss2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        for (String key : map1.keySet()) {
            if (map1.get(key) == 1 && !map2.containsKey(key))
                list.add(key);
            cnt++;
        }
        for (String key : map2.keySet()) {
            if (map2.get(key) == 1 && !map1.containsKey(key))
                list.add(key);
            cnt++;
        }

        String ans[] = new String[list.size()];
        int idx = 0;
        for (String ele : list) {
            ans[idx++] = ele;
        }
        return ans;

    }
}
