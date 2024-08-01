class Solution {
    // TC:O(N) SC:O(1)
    public int countSeniors1(String[] details) {
        int cnt = 0;
        for (String s : details) {
            String age = s.substring(11, 13);
            int ones = age.charAt(1) - '0';
            int tens = age.charAt(0) - '0';
            int numAge = tens * 10 + ones;
            if (numAge > 60) {
                cnt++;
            }
        }
        return cnt;
    }

    /// 2nd method
    public int countSeniors(String[] details) {
        int cnt = 0;
        for (String s : details) {
            int tens = s.charAt(11) - '0';
            int ones = s.charAt(12) - '0';
            int numAge = tens * 10 + ones;
            if (numAge > 60) {
                cnt++;
            }
        }
        return cnt;
    }
}