
import java.util.*;

class Solution {

    private String getFreqString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (String s : strs) {
            //get the sorted freq string of s
            String freqS = getFreqString(s);
            //if map contains this sorted freq string add this s to map
            if (map.containsKey(freqS)) {
                map.get(freqS).add(s);
            } 
                 ///else create a new List and put in map
            else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(freqS, list);
            }
        }
        //traverse the map to get all grouped anagrams
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }

}
