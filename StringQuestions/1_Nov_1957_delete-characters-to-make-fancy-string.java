package StringQuestions;

class Solution {
    // TC:O(N) SC:O(N) Best 96%beats
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        char prev = s.charAt(0);
        int cnt = 1;// appended one char already
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (prev == curr) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt < 3) {
                sb.append(curr);
            }
            prev = curr;
        }
        return sb.toString();
    }
}

class Solution2 {
    // TC:O(N) SC:O(N)
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i <= sb.length() - 3; i++) { // everytime after deleteion new length will be calculated
            if (sb.charAt(i) == sb.charAt(i + 1) && sb.charAt(i + 1) == sb.charAt(i + 2)) {
                sb.deleteCharAt(i);// after deletion it will shift all chars to left
                i--;
            }
        }
        return sb.toString();
    }
}