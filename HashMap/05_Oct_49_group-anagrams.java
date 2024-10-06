import java.util.*;

class Solution {
    // SC:O(n) SC:O(n*MlogM) N=strs.legnth; m=strs[idx].legnth;
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String freqString = getFreqString(s);
            // System.out.println(freqString);

            if (map.containsKey(freqString)) {
                map.get(freqString).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(freqString, list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }

    private String getFreqString(String s) {
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);

    }
}