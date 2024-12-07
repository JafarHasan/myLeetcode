
class Solution {
    // TC:O(N) SC:O(N)
    public boolean canMakeSubsequence(String str1, String str2) {

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int i = 0, j = 0;
        while (i < ch1.length && j < ch2.length) {
            if ((ch1[i] == ch2[j]) || (ch1[i] == 'z' && ch2[j] == 'a') || (ch2[j] - ch1[i] == 1)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == ch2.length;
    }
}

class Solution2 {
    // TC:O(Math.min(n,m)) SC:O(1)
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
                continue;
            }
            // didnt match the chars so trying to match increment char
            char ch = str1.charAt(i) == 'z' ? 'a' : (char) (str1.charAt(i) + 1);
            if (ch == str2.charAt(j)) {
                j++;
            }
            i++;

        }
        return j == m;
    }
}