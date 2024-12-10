class Solution {
    // TC:O(N) SC:O(1)
    // find each same char substring length and use formula
    // no of substring =len*(len+1)/2;
    public int countHomogenous(String s) {
        // char[] arr=s.toCharArray();//it is a faster approach
        int mod = 1000000007;
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long len = 1;
            while (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                len++;
            }
            long no = len * (len + 1) / 2;
            ans = (int) (ans + no % mod) % mod;
        }
        return ans;
    }
}