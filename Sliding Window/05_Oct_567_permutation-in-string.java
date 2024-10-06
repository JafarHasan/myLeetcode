import java.util.*;

class Solution1 {
    // using a HashMap and sliding window approach 28ms 33.57% beats
    public boolean checkInclusion(String s1, String s2) {
        // int freq[]=new int[26];
        int n = s1.length();
        int m = s2.length();
        if (m < n)
            return false;
        HashMap<Character, Integer> map1 = new HashMap<>();

        // cnt and store each char freq from s1
        for (char ch : s1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        // cnt and store char and freq in first window of size s1
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);

        }
        // check if first window matches
        if (map1.equals(map2))
            return true;

        // slide window and check again n again
        for (int i = n; i < m; i++) {
            // remove char outside the window
            char ch = s2.charAt(i - n);
            map2.put(ch, map2.getOrDefault(ch, 0) - 1);

            if (map2.get(ch) == 0) {
                map2.remove(ch);
            }
            // add new char of this window
            char ch2 = s2.charAt(i);
            map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);
            // check if this window matches
            if (map1.equals(map2))
                return true;

        }

        return false;

    }
}

// II approach
class Solution {
    // using a freq array of 26 size and sliding window approach 7ms 80% beats
    private static final int size = 26;

    public boolean checkInclusion(String s1, String s2) {
        int freqS1[] = new int[size];
        int freqS2[] = new int[size];
        int n = s1.length();
        int m = s2.length();
        if (m < n)
            return false;

        // cnt and store each char freq from s1
        // cnt and store char and freq in first window of size s1
        for (int i = 0; i < s1.length(); i++) {
            freqS1[s1.charAt(i) - 'a']++;
            freqS2[s2.charAt(i) - 'a']++;

        }

        // check if first window matches
        if (Arrays.equals(freqS1, freqS2))
            return true;

        // slide window and check again n again
        for (int i = n; i < m; i++) {
            // remove char outside the window
            char ch = s2.charAt(i - n);
            freqS2[ch - 'a']--;

            // add new char of this window
            ch = s2.charAt(i);
            freqS2[ch - 'a']++;

            // check if this new window matches
            if (Arrays.equals(freqS1, freqS2))
                return true;

        }

        return false;

    }
}