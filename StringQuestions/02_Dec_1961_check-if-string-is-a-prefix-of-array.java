class Solution {
    public boolean isPrefixString(String s, String[] words) {

        StringBuilder sb = new StringBuilder();
        for (var str : words) {
            sb.append(str);
            if (sb.length() > s.length())
                return false;
            if (sb.length() == s.length()) {
                return s.equals(sb.toString());
            }
        }
        return false;
    }
}

class Solution2 {
    public boolean isPrefixString(String s, String[] words) {

        StringBuilder sb = new StringBuilder(s);

        for (String str : words) {
            int n = str.length();
            if (sb.length() == 0)
                return true;
            if (sb.length() >= n && sb.substring(0, n).equals(str)) {
                sb.delete(0, n);

            } else {
                return false;
            }
        }
        return sb.length() == 0;
    }
}