class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        if (n < 3)
            return 0;
        // store first and last Idx
        int[][] pair = new int[26][2];
        // TC:O(26*2)
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 2; j++) {
                pair[i][j] = -1;
            }
        }

        // Find the first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (pair[idx][0] == -1)
                pair[idx][0] = i;
            pair[idx][1] = i;
        }
        int ans = 0;
        for (int row[] : pair) {// TC:O(26)
            int firstIdx = row[0];
            int lastIdx = row[1];
            if (firstIdx == -1 || lastIdx == -1 || firstIdx == lastIdx)
                continue;
            // iterate on pair and check middle chars
            HashSet<Character> set = new HashSet<>();// SC:O(26)
            for (int middle = firstIdx + 1; middle <= lastIdx - 1; middle++) {
                set.add(s.charAt(middle));
            }
            ans += set.size();
        }
        return ans;

    }

    // TC:O(n*26) SC:O(26*26)
    public int countPalindromicSubsequence1(String s) {
        int n = s.length();
        if (n < 3)
            return 0;
        int ans = 0;
        // Store unique Letters SC:O(26)
        HashSet<Character> uniqueLetters = new HashSet<>();
        int freq[] = new int[26];
        for (char ch : s.toCharArray()) {
            uniqueLetters.add(ch);
        }
        // iterate on unique letters TC:O(26)
        for (char ch : uniqueLetters) {
            // get first and last occurance
            int firstIdx = s.indexOf(ch);// O(N)
            int lastIdx = s.lastIndexOf(ch);// O(N)
            // if anyone is -1 means only one occurance/or none we cant form a 3 length
            // palin..
            if (firstIdx == -1 || lastIdx == -1)
                continue;
            // check middle chars between first and last occurance
            // for unique chars
            HashSet<Character> set = new HashSet<>();// SC:O(26)
            for (int middle = firstIdx + 1; middle <= lastIdx - 1; middle++) {
                set.add(s.charAt(middle));
            }
            ans += set.size();
        }

        return ans;

    }
}