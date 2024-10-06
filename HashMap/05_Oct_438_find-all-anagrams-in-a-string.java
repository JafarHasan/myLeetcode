import java.util.*;

class Solution {
    //EXACTLY SAME QUESTION 567_PERMUTATION IN A STRING
    
    // 9ms TC:O(N) SC:O(26)->O(1)
    public List<Integer> findAnagrams(String s, String p) {
        int n = p.length();
        int m = s.length();
        if (n > m)
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int freqP[] = new int[26];
        for (char ch : p.toCharArray()) {
            freqP[ch - 'a']++;
        }

        int freqS[] = new int[26];
        // find first window with size p.legnth();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freqS[ch - 'a']++;
        }
        if (Arrays.equals(freqP, freqS))
            list.add(0);
        for (int i = n; i < m; i++) {
            char ch = s.charAt(i - n);
            // remove first char from window
            freqS[ch - 'a']--;
            // add curr char to window and increase its cnt
            ch = s.charAt(i);
            freqS[ch - 'a']++;

            // add the index in ans from where new permutation started
            if (Arrays.equals(freqP, freqS))
                list.add(i - n + 1);

        }
        return list;

    }
}