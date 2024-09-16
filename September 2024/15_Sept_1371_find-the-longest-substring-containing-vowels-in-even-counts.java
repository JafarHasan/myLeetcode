class Solution1 {
    // TC:O(n*5) =O(N) SC:O(N) N=length of s 451ms
    public int findTheLongestSubstring(String s) {
        int vowel[] = new int[5];
        String currState = "00000";
        int len = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put(currState, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                vowel[0] = (vowel[0] + 1) % 2;
            } else if (ch == 'e') {
                vowel[1] = (vowel[1] + 1) % 2;
            } else if (ch == 'i') {
                vowel[2] = (vowel[2] + 1) % 2;
            } else if (ch == 'o') {
                vowel[3] = (vowel[3] + 1) % 2;
            } else if (ch == 'u') {
                vowel[4] = (vowel[4] + 1) % 2;
            }
            currState = "";
            for (int j = 0; j < 5; j++) {
                currState += vowel[j] + "";
            }
            if (map.containsKey(currState)) {
                int lastIdx = map.get(currState);
                len = Math.max(len, i - lastIdx);
            } else {
                map.put(currState, i);
            }
        }
        return len;
    }
}

// even no of time XOR with 1 gives 0
class Solution2 {

    public int findTheLongestSubstring(String s) {
        int vowel[] = new int[5];
        String currState = "00000";
        int len = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put(currState, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                vowel[0] = vowel[0] ^ 1;
            } else if (ch == 'e') {
                vowel[1] = (vowel[1] ^ 1);
            } else if (ch == 'i') {
                vowel[2] = (vowel[2] ^ 1);
            } else if (ch == 'o') {
                vowel[3] = (vowel[3] ^ 1);
            } else if (ch == 'u') {
                vowel[4] = (vowel[4] ^ 1);
            }
            currState = "";
            for (int j = 0; j < 5; j++) {
                currState += (vowel[j]);
            }
            if (map.containsKey(currState)) {
                int lastIdx = map.get(currState);
                len = Math.max(len, i - lastIdx);
            } else {
                map.put(currState, i);
            }
        }
        return len;
    }
}

// TC:O(N) SC:O(N) 43ms
/**
 * mask=1 mens in binary=00000 binary no read right to left
 * for a shift 1 0 times
 * 00001
 * for e shift 1 1 times ans so on
 * XOR with mask
 * 
 * 00000
 * xor 00001
 * -----------
 * 00001
 * 
 */
class Solution {

    public int findTheLongestSubstring(String s) {
        int vowel[] = new int[5];
        int mask = 0;// binary=00000
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(mask, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                mask = (mask) ^ (1 << 0); // shift 1 ,0 times
            } else if (ch == 'e') {
                mask = (mask) ^ (1 << 1);
            } else if (ch == 'i') {
                mask = (mask) ^ (1 << 2);
            } else if (ch == 'o') {
                mask = (mask) ^ (1 << 3);
            } else if (ch == 'u') {
                mask = (mask) ^ (1 << 4);
            }

            if (map.containsKey(mask)) {
                int lastIdx = map.get(mask);
                len = Math.max(len, i - lastIdx);
            } else {
                map.put(mask, i);
            }
        }
        return len;
    }
}
