
import java.util.*;

class Solution {

    //TC:O(N*K)+O(M*K)//n words1 size m=words2 size and k the longest string size 
    //TC:O(N+M)
    //SC:O(26*3)=>O(78)=>O(1)
    public List<String> wordSubsets(String[] words1, String[] words2) {

        int maxFreq[] = new int[26];
        //iterate Each String in words1 and count freq of each chars
        for (String s : words2) {
            // freq array of words 2
            int[] w2 = new int[26];
            for (char ch : s.toCharArray()) {
                w2[ch - 'a']++;
            }
            // max Freq
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], w2[i]); // Take max frequency across all strings
            }

        }
        List<String> ans = new ArrayList<>();
        // iterate over words1 and check if it contains all subset
        for (String s : words1) {
            int w1[] = new int[26];
            boolean flag = true;
            //curr String in words1 thats need to be checked if its a universal string
            for (char ch : s.toCharArray()) {
                w1[ch - 'a']++;
            }
            // check if curr string freq contains all subset string using freq
            for (int i = 0; i < 26; i++) {
                if (maxFreq[i] > w1[i]) {
                    flag = false;
                    break;
                }

            }
            if (flag) {

                ans.add(s);
            }
        }
        return ans;

    }
}
