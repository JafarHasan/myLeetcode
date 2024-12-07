package StringQuestions;

import java.util.*;

class Solution {
    // TC:O(N) SC:O(N)
    public int numMatchingSubseq(String s, String[] words) {
        int cnt = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String key : map.keySet()) {
            if (isSubsequence(s, key)) {
                cnt += map.get(key);
            }
        }
        return cnt;
    }

    private boolean isSubsequence(String s, String str) {
        int i = 0, j = 0;
        while (i < s.length() && j < str.length()) {
            if (s.charAt(i) == str.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == str.length();
    }
}

// TLE 44/55 when we need to find same subsequence again and again
// TC:O(NxM) N=length of words[] M=longest length of words[i];
// SC:O(1)
class Solution2 {
    public int numMatchingSubseq(String s, String[] words) {
        int cnt = 0;
        for (String str : words) {
            if (isSubsequence(s, str)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isSubsequence(String s, String str) {
        int i = 0, j = 0;
        while (i < s.length() && j < str.length()) {
            if (s.charAt(i) == str.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == str.length();
    }
}
