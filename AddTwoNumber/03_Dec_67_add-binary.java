
class Solution {
    // TC:O(N) SC:O(1)
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        int j = m - 1;
        int i = n - 1;
        int c = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int d1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int d2 = j >= 0 ? b.charAt(j) - '0' : 0;
            i--;
            j--;
            int sum = d1 + d2 + c;
            sb.append(sum % 2);
            c = sum / 2;

        }
        if (c == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}